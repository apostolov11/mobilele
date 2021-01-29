package bg.softuni.mobilele.mobilele.service.impl;

import bg.softuni.mobilele.mobilele.model.entities.Brand;
import bg.softuni.mobilele.mobilele.model.entities.Model;
import bg.softuni.mobilele.mobilele.model.view.BrandViewModel;
import bg.softuni.mobilele.mobilele.model.view.ModelVewModel;
import bg.softuni.mobilele.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.mobilele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(ModelRepository modelRepository,ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {

        List<BrandViewModel> result = new ArrayList<>(); // <- final result here

        List<Model> allModels = modelRepository.findAll();


        allModels.forEach(m -> {
            Brand brand = m.getBrand();
            Optional<BrandViewModel> brandViewModelOpt = findByName(result,brand.getName());

            if (!brandViewModelOpt.isPresent()) {
                // not yet in the result , we will create a new model
                BrandViewModel newBrandViewModel = new BrandViewModel();
                modelMapper.map(brand,newBrandViewModel);
                result.add(newBrandViewModel);
                brandViewModelOpt = Optional.of(newBrandViewModel);
            }

            ModelVewModel newModelViewModel = new ModelVewModel();
            modelMapper.map(m,newModelViewModel);
            brandViewModelOpt.get().addModel(newModelViewModel);

        });

        return result;
    }

    private static Optional<BrandViewModel> findByName (List<BrandViewModel> allModels, String name) {
       return allModels.stream().filter(m -> m.getName().equals(name)).findAny();
    }
}

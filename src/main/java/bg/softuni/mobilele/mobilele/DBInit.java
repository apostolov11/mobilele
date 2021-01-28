package bg.softuni.mobilele.mobilele;

import bg.softuni.mobilele.mobilele.model.entities.BaseEntity;
import bg.softuni.mobilele.mobilele.model.entities.Brand;
import bg.softuni.mobilele.mobilele.model.entities.Model;
import bg.softuni.mobilele.mobilele.model.entities.enums.ModelCategory;
import bg.softuni.mobilele.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.mobilele.repository.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Brand fordBrand = new Brand();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);



        Brand hondaBrand = new Brand();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));
        initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);


    }

    private  Model initNC750S(Brand hondaBrand) {
        Model nc750s = new Model();


        nc750s.setName("NC750S");
        nc750s.setCategory(ModelCategory.MOTORCYCLE);
        nc750s.setImageUrl("https://www.motoroads.com/photos/big-honda-nc750x-motorcycle-rental-in-porto-portugal.jpeg");
        nc750s.setStartYear(2014);
        nc750s.setBrand(hondaBrand);

        setCurrentTimestamps(nc750s);

        return modelRepository.save(nc750s);

    }



    private  Model initEscort(Brand fordBrand) {
        Model fiesta = new Model();


        fiesta.setName("Escort");
        fiesta.setCategory(ModelCategory.CAR);
        fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Ford_Escort_first_reg_Jan_1997_1391cc.JPG/275px-Ford_Escort_first_reg_Jan_1997_1391cc.JPG");
        fiesta.setStartYear(1968);
        fiesta.setEndYear(2002);
        fiesta.setBrand(fordBrand);

        setCurrentTimestamps(fiesta);

        return modelRepository.save(fiesta);

    }

    private  Model initFiesta(Brand fordBrand) {
        Model fiesta = new Model();


        fiesta.setName("Fiesta");
        fiesta.setCategory(ModelCategory.CAR);
        fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/275px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        fiesta.setStartYear(1976);
        fiesta.setBrand(fordBrand);

        setCurrentTimestamps(fiesta);

        return modelRepository.save(fiesta);

    }

    private static void setCurrentTimestamps(BaseEntity baseEntity) {
        baseEntity.setCreated(Instant.now());
        baseEntity.setUpdated(Instant.now());
    }
}

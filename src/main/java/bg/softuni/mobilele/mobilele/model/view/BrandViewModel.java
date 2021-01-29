package bg.softuni.mobilele.mobilele.model.view;

import java.util.ArrayList;
import java.util.List;

public class BrandViewModel {

    private String name;

    private List<ModelVewModel> models = new ArrayList<>();

    public List<ModelVewModel> getModels() {
        return models;
    }

    public BrandViewModel addModel (ModelVewModel modelVewModel) {
        this.models.add(modelVewModel);
        return this;
    }

    public void setModels(List<ModelVewModel> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandViewModel{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}

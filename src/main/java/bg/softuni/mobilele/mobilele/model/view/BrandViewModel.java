package bg.softuni.mobilele.mobilele.model.view;

import java.util.List;

public class BrandViewModel {

    private String name;

    private List<ModelVewModel> models;

    public List<ModelVewModel> getModels() {
        return models;
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

package br.com.store.backend.view.resource.location;

public enum DistrictLinks {
    CITIES("cities");

    private String description;

    public String getDescription() {
        return description;
    }

    private DistrictLinks(String description) {
        this.description = description;
    }
}

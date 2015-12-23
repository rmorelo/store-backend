package br.com.store.backend.view.resource.partner;

public enum CityLinks {
    FEDERATIONS_UNITS("federation-units");

    private String description;

    public String getDescription() {
        return description;
    }

    private CityLinks(String description) {
        this.description = description;
    }
}

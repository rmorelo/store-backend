package br.com.store.backend.view.resource.partner;

public enum FederationUnitLinks {
    COUNTRIES("countries");

    private String description;

    public String getDescription() {
        return description;
    }

    private FederationUnitLinks(String description) {
        this.description = description;
    }
}

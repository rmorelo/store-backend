package br.com.store.backend.view.resource.partner;

public enum PostalAreaLinks {
    DISTRICTS("districts");

    private String description;

    public String getDescription() {
        return description;
    }

    private PostalAreaLinks(String description) {
        this.description = description;
    }
}

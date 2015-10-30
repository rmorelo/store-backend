package br.com.store.backend.view.resource.partner;

public enum PartnerLinks {
    CONTACTS("contacts");

    private String description;

    public String getDescription() {
        return description;
    }

    private PartnerLinks(String description) {
        this.description = description;
    }
}

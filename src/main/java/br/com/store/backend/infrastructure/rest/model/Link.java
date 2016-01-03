package br.com.store.backend.infrastructure.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {

    private String rel;

    private String href;
    
    @JsonCreator
    public Link(@JsonProperty("rel") String rel, @JsonProperty("href") String href) {
        this.rel = rel;
        this.href = href;
    }
    
    public String getRel() {
        return rel;
    }

    public String getHref() {
        return href;
    }

}

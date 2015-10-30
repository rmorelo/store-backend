package br.com.store.backend.infrastructure.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {

    private String rel;

    private String href;

    private String method;

    @JsonCreator
    public Link(@JsonProperty("rel") String rel, @JsonProperty("href") String href, @JsonProperty("method") String method) {
        this.rel = rel;
        this.href = href;
        this.method = method;
    }
    
    public String getRel() {
        return rel;
    }

    public String getHref() {
        return href;
    }

    public String getMethod() {
        return method;
    }

    public void setHref(String href) {
        this.href = href;
    }
}

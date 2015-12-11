package br.com.store.backend.infrastructure.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.store.backend.infrastructure.rest.model.Link;

public interface Linkable {

    String getUri();

    boolean hasLink();

    List<Link> getLinks();

    void addLink(Link link);
    
    @JsonIgnore
    boolean hasNextPage();

    @JsonIgnore
    String getNextPageHref();

}

package br.com.store.backend.infrastructure.rest;

import java.util.List;

import br.com.store.backend.infrastructure.rest.model.Link;

public interface Linkable {

    String getUri();

    boolean hasLink();

    List<Link> getLinks();

    void addLink(Link link);

    void addLink(int index, Link link);

}

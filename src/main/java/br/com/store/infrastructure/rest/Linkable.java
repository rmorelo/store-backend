package br.com.store.infrastructure.rest;

import java.util.List;

import br.com.store.infrastructure.rest.model.Link;

public interface Linkable {

    String getUri();

    boolean hasLink();

    List<Link> getLinks();

    void addLink(Link link);

    void addLink(int index, Link link);

}

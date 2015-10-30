package br.com.store.backend.domain.entity;

import java.util.List;

import br.com.store.backend.infrastructure.rest.Linkable;
import br.com.store.backend.infrastructure.rest.model.Link;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartnerEntity implements Linkable {

    private Long id;
    
    private String name;
    
    private String uri;
    
    private List<Link> links;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUri() {
        return uri;
    }
    
    public void setUri(String uri) {
        this.uri = uri;
    }
    
    @Override
    public boolean hasLink() {
        return !links.isEmpty();
    }

    public List<Link> getLinks() {
        return links;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public void addLink(int index, Link link) {
        links.add(index, link);
    }

}

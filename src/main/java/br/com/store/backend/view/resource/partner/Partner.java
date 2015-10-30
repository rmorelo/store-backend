package br.com.store.backend.view.resource.partner;

import java.util.List;

import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.validation.contraints.Name;
import br.com.store.backend.view.validation.contraints.PartnerResource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@PartnerResource
public class Partner {

    public static final String FIELD_NAME = "name";    
    public static final String STATUS_ACTIVE = "ACTIVE";

    public interface CompanyProfile {
    }

    public interface IndividualProfile {
    }

    private Long id;

    @Name(groups = Partner.IndividualProfile.class)
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
    
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

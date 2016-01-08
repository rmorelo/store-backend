package br.com.store.backend.view.resource.pet;

import java.io.Serializable;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group implements Serializable{

	private static final long serialVersionUID = 8556860560387369226L;

	private Integer idGroup;
    
    private String name;
    
    private Collection<Species> species;
    
    private String uri;
    
    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Collection<Species> getSpecies() {
        return species;
    }

    public void setSpecies(Collection<Species> species) {
        this.species = species;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri, String queryParam) {
        this.uri = uri + (queryParam != null ? "?" + queryParam : "");
    }
}

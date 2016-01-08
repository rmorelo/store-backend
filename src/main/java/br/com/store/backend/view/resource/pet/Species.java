package br.com.store.backend.view.resource.pet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import br.com.store.backend.infrastructure.rest.model.Link;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Species implements Serializable{

	private static final long serialVersionUID = -6804544840616204984L;

	public static final String BREEDS = "breeds";
    
    public static final String GROUPS = "groups";
    
    private static final String URI_PATH = "/api/species/";

    private Integer idSpecies;
    
    private String name;
    
    private Collection<Breed> breeds;
    
    private Group group;
    
    private String uri;
    
    private List<Link> links;
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(BREEDS, GROUPS);
    }
    
    public Integer getIdSpecies() {
        return idSpecies;
    }

    public void setIdSpecies(Integer idSpecies) {
        this.idSpecies = idSpecies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Collection<Breed> getBreeds() {
        return breeds;
    }

    public void setBreeds(Collection<Breed> breeds) {
        this.breeds = breeds;
    }
    
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri, String queryParam) {
        this.uri = uri + (queryParam != null ? "?" + queryParam : "");
    }

    public List<Link> getLinks() {
        this.links = new ArrayList<Link>();
        
        for (String resource : getSelectableResources()) {
            Link link = new Link(resource, URI_PATH + this.idSpecies + "/" + resource);
            this.links.add(link);
        }
        return links;
    }
    
}

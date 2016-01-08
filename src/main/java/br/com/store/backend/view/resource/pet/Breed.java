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
public class Breed implements Serializable{

	private static final long serialVersionUID = -7983036896700593659L;

	public static final String ANIMALS = "animals";
    
    public static final String SPECIES = "species";
    
    private static final String URI_PATH = "/api/breeds/";

    private Integer idBreed;
    
    private String name;
    
    private Collection<Animal> animals;
    
    private Species species;
    
    private String uri;
    
    private List<Link> links;
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(ANIMALS, SPECIES);
    }
    
    public Integer getIdBreed() {
        return idBreed;
    }

    public void setIdBreed(Integer idBreed) {
        this.idBreed = idBreed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }
    
    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
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
            Link link = new Link(resource, URI_PATH + this.idBreed + "/" + resource);
            this.links.add(link);
        }
        return links;
    }
    
}

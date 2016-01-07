package br.com.store.backend.view.resource.pet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Animal implements Serializable{

    public static final String WEIGHTS = "weights";
    
    public static final String BREEDS = "breeds";
    
    public static final String CUSTOMERS = "customers";
    
    private static final String URI_PATH = "/api/animals/";

    private Integer idAnimal;
    
    private String name;
    
    private String sex;
    
    private Double age;
    
    private String addtionalInfo;
    
    private String urlPhoto;
    
    private Customer customer;
    
    private Weight weight;
    
    private Collection<Breed> breeds;

    private String uri;
    
    private List<Link> links;
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(WEIGHTS, BREEDS, CUSTOMERS);
    }
    
    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getAddtionalInfo() {
        return addtionalInfo;
    }

    public void setAddtionalInfo(String addtionalInfo) {
        this.addtionalInfo = addtionalInfo;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }
    
    public Collection<Breed> getBreeds() {
        return breeds;
    }

    public void setBreeds(Collection<Breed> breeds) {
        this.breeds = breeds;
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
            Link link = new Link(resource, URI_PATH + this.idAnimal + "/" + resource);
            this.links.add(link);
        }
        return links;
    }
    
}

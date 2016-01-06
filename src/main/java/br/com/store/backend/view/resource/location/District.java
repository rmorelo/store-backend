package br.com.store.backend.view.resource.location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import br.com.store.backend.infrastructure.rest.model.Link;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class District implements Serializable{

	private static final String URI_PATH = "/api/districts/";
	
	public static final String CITIES = "cities";
	
	private static final long serialVersionUID = -9171673824071100365L;

	private Integer idDistrict;
    
    private String namDistrict;
    
    private City city;
    	    
	private String uri;
    
    private List<Link> links;
    
    public District(){
    }
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(CITIES);
    }
    
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public Integer getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(Integer idDistrict) {
		this.idDistrict = idDistrict;
	}

	public String getNamDistrict() {
		return namDistrict;
	}

	public void setNamDistrict(String namDistrict) {
		this.namDistrict = namDistrict;
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
            Link link = new Link(resource, URI_PATH + this.idDistrict +  "/" + resource);
            this.links.add(link);
        }
        return links;
    }
}

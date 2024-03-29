package br.com.store.backend.view.resource.location;

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
public class PostalArea implements Serializable{

	private static final String URI_PATH = "/api/postalareas/";
	
	private static final long serialVersionUID = -9171673824071100365L;
	
	public static final String DISTRICS = "districts";
	
	private Integer idPostalArea;
	
	private Integer idCity;
    
    private String namPostalArea;
    
    private String codPostalArea;
    
    private String desSegment;
    
    private Integer idParentPostalArea;
    
    private Collection<District> districts;
    
    private City city;
        
	private String uri;
    
    private List<Link> links;
    
    public PostalArea(){
    }
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(DISTRICS);
    }
    
    public Integer getIdPostalArea() {
		return idPostalArea;
	}

	public void setIdPostalArea(Integer idPostalArea) {
		this.idPostalArea = idPostalArea;
	}

	public Integer getIdCity() {
		return idCity;
	}

	public void setIdCity(Integer idCity) {
		this.idCity = idCity;
	}

	public String getNamPostalArea() {
		return namPostalArea;
	}

	public void setNamPostalArea(String namPostalArea) {
		this.namPostalArea = namPostalArea;
	}

	public String getCodPostalArea() {
		return codPostalArea;
	}

	public void setCodPostalArea(String codPostalArea) {
		this.codPostalArea = codPostalArea;
	}

	public String getDesSegment() {
		return desSegment;
	}

	public void setDesSegment(String desSegment) {
		this.desSegment = desSegment;
	}

	public Integer getIdParentPostalArea() {
		return idParentPostalArea;
	}

	public void setIdParentPostalArea(Integer idParentPostalArea) {
		this.idParentPostalArea = idParentPostalArea;
	}
	
	public Collection<District> getDistricts() {
		return districts;
	}

	public void setDistricts(Collection<District> districts) {
		this.districts = districts;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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
            Link link = new Link(resource, URI_PATH + this.idPostalArea + "/" + resource);
            this.links.add(link);
        }
        return links;
    }
}

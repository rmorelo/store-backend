package br.com.store.backend.view.resource.partner;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import br.com.store.backend.infrastructure.rest.Linkable;
import br.com.store.backend.infrastructure.rest.model.Link;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostalArea implements Serializable, Linkable{

	private static final long serialVersionUID = -9171673824071100365L;
	
	public static final String CITIES = "cities";
	
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
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(DISTRICS, CITIES);
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

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

	@Override
	public boolean hasLink() {
        return !links.isEmpty();
	}

	@Override
	public void addLink(Link link) {
        links.add(link);		
	}
	
	@Override public boolean hasNextPage() {
        return false;
    }

    @Override public String getNextPageHref() {
        return null;
    }
}

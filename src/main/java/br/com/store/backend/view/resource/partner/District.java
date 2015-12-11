package br.com.store.backend.view.resource.partner;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import br.com.store.backend.infrastructure.rest.Linkable;
import br.com.store.backend.infrastructure.rest.model.Link;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class District implements Serializable, Linkable{

	private static final long serialVersionUID = -9171673824071100365L;

	public static final String CITY = "city";
	
	private Integer idDistrict;
	
	private Integer idCity;
    
    private String namDistrict;
    	    
	private String uri;
    
    private List<Link> links;
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(CITY);
    }
    
	public Integer getIdCity() {
		return idCity;
	}

	public void setIdCity(Integer idCity) {
		this.idCity = idCity;
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

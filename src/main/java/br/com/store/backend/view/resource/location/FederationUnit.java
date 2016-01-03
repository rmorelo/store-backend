package br.com.store.backend.view.resource.location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.store.backend.infrastructure.rest.Linkable;
import br.com.store.backend.infrastructure.rest.model.Link;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FederationUnit implements Serializable, Linkable{

	private static final String URI_PATH = "/api/federation-units/";
	
	public static final String COUNTRIES = "countries";
	
	private static final long serialVersionUID = -4227637322758177840L;

	private Integer idFederationUnit;
	
    private String namFederationUnit;
    
    private String abvFederationUnit;
    
    private Country country;
    
	private String uri;
    
    private List<Link> links;
    
    public FederationUnit(){
    }
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(COUNTRIES);
    }
	
	public Integer getIdFederationUnit() {
		return idFederationUnit;
	}

	public void setIdFederationUnit(Integer idFederationUnit) {
		this.idFederationUnit = idFederationUnit;
	}

	public String getNamFederationUnit() {
		return namFederationUnit;
	}

	public void setNamFederationUnit(String namFederationUnit) {
		this.namFederationUnit = namFederationUnit;
	}

	public String getAbvFederationUnit() {
		return abvFederationUnit;
	}

	public void setAbvFederationUnit(String abvFederationUnit) {
		this.abvFederationUnit = abvFederationUnit;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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
            Link link = new Link(resource, URI_PATH + this.idFederationUnit + "/" + resource);
            this.links.add(link);
        }
        return links;
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

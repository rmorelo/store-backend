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
public class FederationUnit implements Serializable, Linkable{

	public static final String COUNTRIES = "countries";
	
	private static final long serialVersionUID = -4227637322758177840L;

	private Integer idFederationUnit;
	
    private String namFederationUnit;
    
    private String abvFederationUnit;
    
    private Country country;
    
	private String uri;
    
    private List<Link> links;
    
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

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
public class City implements Serializable, Linkable{

	public static final String FEDERATION_UNITS = "federation-units";
	
	private static final long serialVersionUID = -9171673824071100365L;
	
	private Integer idCity;
    
	private FederationUnit federationUnit;
	
    private String namCity;
    
    private String namCityOriginal;
    
    private String codPostalCity;
    
    private String codIbge;
    
	private String uri;
    
    private List<Link> links;
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(FEDERATION_UNITS);
    }
    
	public Integer getIdCity() {
		return idCity;
	}

	public void setIdCity(Integer idCity) {
		this.idCity = idCity;
	}
	
	public FederationUnit getFederationUnit() {
		return federationUnit;
	}

	public void setFederationUnit(FederationUnit federationUnit) {
		this.federationUnit = federationUnit;
	}

	public String getNamCity() {
		return namCity;
	}

	public void setNamCity(String namCity) {
		this.namCity = namCity;
	}

	public String getNamCityOriginal() {
		return namCityOriginal;
	}

	public void setNamCityOriginal(String namCityOriginal) {
		this.namCityOriginal = namCityOriginal;
	}

	public String getCodPostalCity() {
		return codPostalCity;
	}

	public void setCodPostalCity(String codPostalCity) {
		this.codPostalCity = codPostalCity;
	}

	public String getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(String codIbge) {
		this.codIbge = codIbge;
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

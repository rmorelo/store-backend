package br.com.store.backend.view.resource.partner;

import java.io.Serializable;
import java.util.List;
import br.com.store.backend.infrastructure.rest.Linkable;
import br.com.store.backend.infrastructure.rest.model.Link;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Serializable, Linkable{

	private static final long serialVersionUID = 751976419909654745L;

	private Integer idCountry;
		
    private String namCountry;
    
    private String namCountryEnglish;
    
    private String abv2Country;
    
    private String abv3Country;
    
	private Integer flgPostalBase;
	
	private Integer numDDICountry;
    
	private String uri;
    
    private List<Link> links;
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return null;
    }
   
	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public String getNamCountry() {
		return namCountry;
	}

	public void setNamCountry(String namCountry) {
		this.namCountry = namCountry;
	}

	public String getNamCountryEnglish() {
		return namCountryEnglish;
	}

	public void setNamCountryEnglish(String namCountryEnglish) {
		this.namCountryEnglish = namCountryEnglish;
	}

	public String getAbv2Country() {
		return abv2Country;
	}

	public void setAbv2Country(String abv2Country) {
		this.abv2Country = abv2Country;
	}

	public String getAbv3Country() {
		return abv3Country;
	}

	public void setAbv3Country(String abv3Country) {
		this.abv3Country = abv3Country;
	}

	public Integer getFlgPostalBase() {
		return flgPostalBase;
	}

	public void setFlgPostalBase(Integer flgPostalBase) {
		this.flgPostalBase = flgPostalBase;
	}

	public Integer getNumDDICountry() {
		return numDDICountry;
	}

	public void setNumDDICountry(Integer numDDICountry) {
		this.numDDICountry = numDDICountry;
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

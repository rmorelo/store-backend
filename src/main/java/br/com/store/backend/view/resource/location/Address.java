package br.com.store.backend.view.resource.location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import br.com.store.backend.infrastructure.rest.model.Link;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Serializable{
	
	private static final long serialVersionUID = 5980144247797985004L;

	private static final String URI_PATH = "/api/addresses/";
	
	public static final String POSTALAREAS = "postalareas";
	
	private Integer idAddress;

	private PostalArea postalArea;
    
    private Integer numAddress;
    
    private String desAddressComplement;
    
    private String indAddressType;

	private Date signupDate;
    
    private String uri;
    
    private List<Link> links;
    
    public Address(){
    }
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(POSTALAREAS);
    }
 	
	public Integer getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Integer idAddress) {
		this.idAddress = idAddress;
	}

	public PostalArea getPostalArea() {
		return postalArea;
	}

	public void setPostalArea(PostalArea postalArea) {
		this.postalArea = postalArea;
	}

	public Integer getNumAddress() {
		return numAddress;
	}

	public void setNumAddress(Integer numAddress) {
		this.numAddress = numAddress;
	}

	public String getDesAddressComplement() {
		return desAddressComplement;
	}

	public void setDesAddressComplement(String desAddressComplement) {
		this.desAddressComplement = desAddressComplement;
	}

	public String getIndAddressType() {
		return indAddressType;
	}

	public void setIndAddressType(String indAddressType) {
		this.indAddressType = indAddressType;
	}
	
	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
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
            Link link = new Link(resource, URI_PATH + this.idAddress + "/" + resource);
            this.links.add(link);
        }
        return links;
    }
}

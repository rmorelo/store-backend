package br.com.store.backend.view.resource.contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.store.backend.infrastructure.rest.model.Link;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Telephone implements Serializable{

	private static final long serialVersionUID = -5433552527906974467L;

	private static final String URI_PATH = "/api/telephones/";
	
	private Integer idTelephone;
    
    private String type;
    
    private String number;
    
    private String ddd;
    
    private String ddi;

    private String confirmation;
	    
	private String uri;
    
    private List<Link> links;
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return null;
    }
    
    public Integer getIdTelephone() {
		return idTelephone;
	}

	public void setIdTelephone(Integer idTelephone) {
		this.idTelephone = idTelephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
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
            Link link = new Link(resource, URI_PATH + this.idTelephone + "/" + resource);
            this.links.add(link);
        }
        return links;
    }
}

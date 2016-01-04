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
public class Email implements Serializable{

	private static final long serialVersionUID = -8349430254253463535L;

	private static final String URI_PATH = "/api/emails/";
	
	private Integer idEmail;
    	
    private String email;
	
	private String confirmation;
	    
	private String uri;
    
    private List<Link> links;
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return null;
    }
    
	public Integer getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
            Link link = new Link(resource, URI_PATH + this.idEmail + "/" + resource);
            this.links.add(link);
        }
        return links;
    }
}

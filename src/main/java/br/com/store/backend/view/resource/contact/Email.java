package br.com.store.backend.view.resource.contact;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Email implements Serializable{

	private static final long serialVersionUID = -8349430254253463535L;
	
	private Integer idEmail;
    	
    private String email;
	
	private String confirmation;
	    
	private String uri;
    
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
}

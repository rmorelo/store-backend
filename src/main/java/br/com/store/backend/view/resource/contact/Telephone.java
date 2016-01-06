package br.com.store.backend.view.resource.contact;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Telephone implements Serializable{

	private static final long serialVersionUID = -5433552527906974467L;
	
	private Integer idTelephone;
    
    private String type;
    
    private String number;
    
    private String ddd;
    
    private String ddi;

    private String confirmation;
	    
	private String uri;
    
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
}

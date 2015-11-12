package br.com.store.backend.view.resource.partner;

import java.io.Serializable;
import java.util.List;

import br.com.store.backend.infrastructure.rest.model.Link;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company implements Serializable{

    private Integer idPartner;
    
    private String cnpj;
    
    private String company_name;
    
    private String state_registration;
    
    private String commercial_name;
	
    private Partner partner;
    
	private String uri;
    
    private List<Link> links;
    
	public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Integer getIdPartner() {
		return idPartner;
	}

	public void setIdPartner(Integer idPartner) {
		this.idPartner = idPartner;
	}
	
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getState_registration() {
        return state_registration;
    }

    public void setState_registration(String state_registration) {
        this.state_registration = state_registration;
    }

    public String getCommercial_name() {
        return commercial_name;
    }

    public void setCommercial_name(String commercial_name) {
        this.commercial_name = commercial_name;
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
}

package br.com.store.backend.view.resource.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import br.com.store.backend.domain.entity.person.PersonTypeEnum;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.contact.Email;
import br.com.store.backend.view.resource.contact.Telephone;
import br.com.store.backend.view.resource.location.Address;
import br.com.store.backend.view.resource.partner.Partner;
import br.com.store.backend.view.resource.person.Individual;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer implements Serializable{

	private static final long serialVersionUID = 5300621263838588237L;

	public static final String ADDRESSES = "addresses";
	
	public static final String INDIVIDUALS = "individuals";
	
	public static final String TELEPHONES = "telephones";
	    
	public static final String EMAILS = "emails";
	
	public static final String PARTNERS = "partners";
	
	private static final String URI_PATH = "/api/customers/";
	
	private Integer idCustomer;
    
    private String urlPhoto;
	
	private Date signupDate;
	
	private String customerType;
	
	private Address address;
	
	private Email email;
	
	private Telephone telephone;
	
	private Individual individual;
	
	private Collection<Partner> partners;
		
	private String uri;
    
    private List<Link> links;
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(ADDRESSES, INDIVIDUALS, TELEPHONES, EMAILS, PARTNERS);
    }
    
	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

    public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    
    public Telephone getTelephone() {
		return telephone;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}
	
	public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
    
    public Collection<Partner> getPartners() {
		return partners;
	}

	public void setPartners(Collection<Partner> partners) {
		this.partners = partners;
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
    	    if(resource == INDIVIDUALS && this.getCustomerType().equals(PersonTypeEnum.PESSOA_FISICA.getType())){
    	        Link link = new Link(resource, URI_PATH + this.idCustomer + "/" + resource);
                this.links.add(link);
    	    }else if(resource != INDIVIDUALS){
    	        Link link = new Link(resource, URI_PATH + this.idCustomer + "/" + resource);
                this.links.add(link);
    	    }    	    
        }
        return links;
    }

}

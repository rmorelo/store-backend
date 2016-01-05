package br.com.store.backend.view.resource.partner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.store.backend.domain.entity.person.PersonTypeEnum;
import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.contact.Email;
import br.com.store.backend.view.resource.contact.Telephone;
import br.com.store.backend.view.resource.location.Address;
import br.com.store.backend.view.resource.person.Company;
import br.com.store.backend.view.resource.person.Individual;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Partner implements Serializable{

	private static final long serialVersionUID = 5300621263838588237L;

	public static final String ADDRESSES = "addresses";
	
	public static final String INDIVIDUALS = "individuals";
	
	public static final String COMPANIES = "companies";
	
	public static final String TELEPHONES = "telephones";
	
	public static final String EMAILS = "emails";
		
	private static final String URI_PATH = "/api/partners/";
	
	private Integer idPartner;
    
	private Integer idContact;
	
    private String description;
	
	private Address address;
	
	private Integer likes;

    private String urlLogo;
	
    private String urlSite;
	
    private String urlFacebook;
	
    private String urlGooglePlus;
	
    private String usernameInstagram;
    
    private String usernameTwitter;
	
	private Date signupDate;
	
	private String partnerType;
	
	private Email email;
	
	private Telephone telephone;
	
	private Individual individual;
	
	private Company company;
	
	private String uri;
    
    private List<Link> links;
    
    @JsonIgnore
    public static List<String> getSelectableResources() {
        return Arrays.asList(ADDRESSES, COMPANIES, INDIVIDUALS, TELEPHONES, EMAILS);
    }
    
	public Integer getIdPartner() {
		return idPartner;
	}

	public void setIdPartner(Integer idPartner) {
		this.idPartner = idPartner;
	}
	
	public Integer getIdContact() {
		return idContact;
	}

	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLike(Integer likes) {
		this.likes = likes;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public String getUrlSite() {
		return urlSite;
	}

	public void setUrlSite(String urlSite) {
		this.urlSite = urlSite;
	}

	public String getUrlFacebook() {
		return urlFacebook;
	}

	public void setUrlFacebook(String urlFacebook) {
		this.urlFacebook = urlFacebook;
	}

	public String getUrlGooglePlus() {
		return urlGooglePlus;
	}

	public void setUrlGooglePlus(String urlGooglePlus) {
		this.urlGooglePlus = urlGooglePlus;
	}

	public String getUsernameInstagram() {
		return usernameInstagram;
	}

	public void setUsernameInstagram(String usernameInstagram) {
		this.usernameInstagram = usernameInstagram;
	}
	
	public String getUsernameTwitter() {
        return usernameTwitter;
    }

    public void setUsernameTwitter(String usernameTwitter) {
        this.usernameTwitter = usernameTwitter;
    }

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

    public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
    	    if(resource == COMPANIES && this.getPartnerType().equals(PersonTypeEnum.PESSOA_JURIDICA.getType())){
    	        Link link = new Link(resource, URI_PATH + this.idPartner + "/" + resource);
	            this.links.add(link);    	           
    	    }else if(resource == INDIVIDUALS && this.getPartnerType().equals(PersonTypeEnum.PESSOA_FISICA.getType())){
    	        Link link = new Link(resource, URI_PATH + this.idPartner + "/" + resource);
                this.links.add(link);
    	    }else if(resource != COMPANIES && resource != INDIVIDUALS){
    	        Link link = new Link(resource, URI_PATH + this.idPartner + "/" + resource);
                this.links.add(link);
    	    }    	    
        }
        return links;
    }

}

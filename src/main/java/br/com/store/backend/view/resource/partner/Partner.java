package br.com.store.backend.view.resource.partner;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.store.backend.infrastructure.rest.model.Link;
import br.com.store.backend.view.resource.contact.Email;
import br.com.store.backend.view.resource.contact.Telephone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Partner implements Serializable{

	private static final long serialVersionUID = 5300621263838588237L;

	private Integer idPartner;
    
	private Integer idContact;
	
    private String description;
	
	private Integer idAddress;
	
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
	
	private String uri;
    
    private List<Link> links;
    
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

	public Integer getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Integer idAddress) {
		this.idAddress = idAddress;
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

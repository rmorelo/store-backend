package br.com.store.backend.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PARTNER")
public class PartnerEntity {
    
	@Id
    @Column(name = "ID_PARTNER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPartner;
    
	@Column(name = "ID_CONTACT")
    private Integer idContact;
	
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Column(name = "ID_ADDRESS")
    private Integer idAddress;
	
	@Column(name = "LIKES")
    private Integer likes;
	
	@Column(name = "PARTNER_TYPE")
    private String partnerType;

	@Column(name = "URL_LOGO")
    private String urlLogo;
	
	@Column(name = "URL_SITE")
    private String urlSite;
	
	@Column(name = "URL_FACEBOOK")
    private String urlFacebook;
	
	@Column(name = "URL_GOOGLE_PLUS")
    private String urlGooglePLus;
	
	@Column(name = "USERNAME_INSTAGRAM")
    private String usernameInstagram;
	
	@Column(name = "USERNAME_TWITTER")
    private String usernameTwitter;
	
	@Column(name = "SIGNUP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	private Date signupDate;
    
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

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
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

	public String getUrlGooglePLus() {
		return urlGooglePLus;
	}

	public void setUrlGooglePLus(String urlGooglePLus) {
		this.urlGooglePLus = urlGooglePLus;
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

	@Override
    public String toString() {
        return "{idPartner:" + idPartner + ",description:" + description + ",idContact:" + idContact
        		+ ",idAddress:" + idAddress + ",like:" + likes + ",partnerType:" + partnerType 
        		+ ",urlLogo:" + urlLogo + ",urlSite:" + urlSite + ",urlFacebook:" + urlFacebook 
        		+ ",urlGooglePLus:" + urlGooglePLus + ",usernameInstagram:" + usernameInstagram
                + ",signupDate:" + signupDate + "}";
    }

}

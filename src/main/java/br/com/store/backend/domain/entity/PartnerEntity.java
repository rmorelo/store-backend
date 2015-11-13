package br.com.store.backend.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.google.common.base.Objects;

@Entity
@Table(name = "PARTNER")
@Inheritance(strategy = InheritanceType.JOINED)
public class PartnerEntity {
    
	@Id
    @Column(name = "ID_PARTNER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idPartner;
    
	@Column(name = "ID_CONTACT")
	protected Integer idContact;
	
	@Column(name = "DESCRIPTION")
	protected String description;
	
	@Column(name = "ID_ADDRESS")
	protected Integer idAddress;
	
	@Column(name = "LIKES")
	protected Integer likes;
	
	@Transient
	protected String partnerType;

	@Column(name = "URL_LOGO")
	protected String urlLogo;
	
	@Column(name = "URL_SITE")
	protected String urlSite;
	
	@Column(name = "URL_FACEBOOK")
	protected String urlFacebook;
	
	@Column(name = "URL_GOOGLE_PLUS")
	protected String urlGooglePlus;
	
	@Column(name = "USERNAME_INSTAGRAM")
	protected String usernameInstagram;
	
	@Column(name = "USERNAME_TWITTER")
	protected String usernameTwitter;
	
	@Column(name = "SIGNUP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	protected Date signupDate;
	
	public PartnerEntity (){
	    
	}
	
	public PartnerEntity (Date signupDate){
        this.signupDate = signupDate;
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

	@Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdPartner() == null ? super.hashCode() : this.getIdPartner().hashCode();
    }
	
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idPartner", idPartner)
                .add("description", description)
                .add("idContact", idContact)
                .add("idAddress", idAddress)
                .add("likes", likes)
                .add("urlLogo", urlLogo)
                .add("urlSite", urlSite)
                .add("urlFacebook", urlFacebook)
                .add("urlGooglePlus", urlGooglePlus)
                .add("usernameInstagram", usernameInstagram)
                .add("signupDate", signupDate)
                .toString();
    }
}
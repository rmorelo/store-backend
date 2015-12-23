package br.com.store.backend.domain.entity.partner;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.store.backend.domain.entity.contact.EmailEntity;
import br.com.store.backend.domain.entity.contact.TelephoneEntity;

import com.google.common.base.Objects;

@Entity
@Table(name = "PARTNER")
@Inheritance(strategy = InheritanceType.JOINED)
public class PartnerEntity {
    
	@Id
    @Column(name = "ID_PARTNER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idPartner;
    	
	@Column(name = "DESCRIPTION")
	protected String description;
	
	@Column(name = "ID_ADDRESS")
	protected Integer idAddress;
	
	@Column(name = "LIKES")
	protected Integer likes;

	@Column(name = "PARTNER_TYPE")
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
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_email")
	private EmailEntity email;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_telephone")
	private TelephoneEntity telephone;
	
	public PartnerEntity (){
	    
	}
	
	public TelephoneEntity getTelephone() {
		return telephone;
	}

	public void setTelephone(TelephoneEntity telephone) {
		this.telephone = telephone;
	}

	public EmailEntity getEmail() {
        return email;
    }

    public void setEmail(EmailEntity email) {
        this.email = email;
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
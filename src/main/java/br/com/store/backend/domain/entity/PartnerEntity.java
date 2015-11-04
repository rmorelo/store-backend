package br.com.store.backend.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARTNER")
public class PartnerEntity {
    
	@Id
    @Column(name = "ID_PARTNER")
    private Integer idPartner;
    
	@Column(name = "ID_CONTACT")
    private Integer desPartner;
	
	@Column(name = "ID_ADDRESS")
    private Integer idAddress;
	
	@Column(name = "LIKE")
    private Integer like;
	
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
    private Integer usernameInstagram;
	
	@Column(name = "SIGNUP_DATE")
    private Date signupDate;
    
    @Override
    public String toString() {
        return "{idPartner:" + idPartner + ",desPartner:" + desPartner + ",idAddress:" + idAddress + ",like:" + like
                + ",partnerType:" + partnerType + ",urlLogo:" + urlLogo + ",urlSite:" + urlSite + ",urlFacebook:"
                + urlFacebook + ",urlGooglePLus:" + urlGooglePLus + ",usernameInstagram:" + usernameInstagram
                + ",signupDate:" + signupDate + "}";
    }

}

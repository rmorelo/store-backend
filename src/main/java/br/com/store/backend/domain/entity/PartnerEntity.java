package br.com.store.backend.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "partner")
public class PartnerEntity  {

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
        final StringBuilder sb = new StringBuilder("PartnerEntity{");
        sb.append("idPartner=").append(idPartner);
        sb.append(", desPartner='").append(desPartner);
        sb.append('}');
        return sb.toString();
    }


}

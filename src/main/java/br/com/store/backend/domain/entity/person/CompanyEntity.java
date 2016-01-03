package br.com.store.backend.domain.entity.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.store.backend.domain.entity.partner.PartnerEntity;

import com.google.common.base.Objects;

@Entity
@Table(name = "COMPANY")
public class CompanyEntity{
    
	@Id
    @Column(name = "ID_COMPANY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompany;
	
    @Column(name = "CNPJ")
    private String cnpj;
    
    @Column(name = "COMPANY_NAME")
    private String companyName;
    
    @Column(name = "STATE_REGISTRATION")
    private String stateRegistration;
    
    @Column(name = "COMMERCIAL_NAME")
    private String commercialName;
    
    @Column(name = "SIGNUP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	private Date signupDate;
    
    @OneToOne(mappedBy = "company", fetch = FetchType.LAZY)
    private PartnerEntity partner;
    
    public Integer getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}

	public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }
    
    public PartnerEntity getPartner() {
		return partner;
	}

	public void setPartner(PartnerEntity partner) {
		this.partner = partner;
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
        return this.getIdCompany() == null ? super.hashCode() : this.getIdCompany().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idCompany", idCompany)
                .add("cnpj", cnpj)
                .add("company_name", companyName)
                .add("state_registration", stateRegistration)
                .add("commercial_name", commercialName)
                .add("partner", partner)
                .add("signupDate", signupDate)
                .toString();
    }
}
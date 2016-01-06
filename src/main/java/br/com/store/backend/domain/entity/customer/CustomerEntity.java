package br.com.store.backend.domain.entity.customer;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.store.backend.domain.entity.contact.EmailEntity;
import br.com.store.backend.domain.entity.contact.TelephoneEntity;
import br.com.store.backend.domain.entity.location.AddressEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.domain.entity.person.IndividualEntity;

import com.google.common.base.Objects;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
    
	@Id
	@Column(name = "ID_CUSTOMER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCustomer;
	
	@Column(name = "URL_PHOTO")
	private String urlPhoto;
	
	@Column(name = "SIGNUP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	protected Date signupDate;
	
	@Column(name = "CUSTOMER_TYPE")
    private String customerType;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_email")
	private EmailEntity email;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_telephone")
	private TelephoneEntity telephone;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_address")
	private AddressEntity address;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_individual")
	private IndividualEntity individual;
	
	@ManyToMany(mappedBy = "customers", fetch = FetchType.EAGER)
    private Set<PartnerEntity> partners;
	
	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public EmailEntity getEmail() {
		return email;
	}

	public void setEmail(EmailEntity email) {
		this.email = email;
	}

	public TelephoneEntity getTelephone() {
		return telephone;
	}

	public void setTelephone(TelephoneEntity telephone) {
		this.telephone = telephone;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
	public IndividualEntity getIndividual() {
		return individual;
	}

	public void setIndividual(IndividualEntity individual) {
		this.individual = individual;
	}
	
	public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    
    public Set<PartnerEntity> getPartners() {
        return partners;
    }

    public void setPartners(Set<PartnerEntity> partners) {
        this.partners = partners;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdCustomer() == null ? super.hashCode() : this.getIdCustomer().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idCustomer", idCustomer)
                .add("urlPhoto", urlPhoto)
                .add("signupDate", signupDate)
                .add("email", email)
                .add("telephone", telephone)
                .add("address", address)
                .add("individual", individual)
                .add("customerType", customerType)
                .add("partners", partners)
                .toString();
    }
}
package br.com.store.backend.domain.entity.location;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import com.google.common.base.Objects;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
    
	@Id
	@Column(name = "ID_ADDRESS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAddress;
	
	@JoinColumn(name = "ID_POSTAL_AREA")
	@OneToOne(fetch = FetchType.LAZY)
	private PostalAreaEntity postalArea;
	
	@Column(name = "NUM_ADDRESS")
	private Integer numAddress;
	
	@Column(name = "DES_ADDRESS_COMPLEMENT")
	private String desAddressComplement;
	
	@Column(name = "IND_ADDRESS_TYPE")
	private String indAddressType;
	
	@Column(name = "SIGNUP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	protected Date signupDate;
	
	@OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
	private PartnerEntity partner;

	public Integer getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Integer idAddress) {
		this.idAddress = idAddress;
	}

	public Integer getNumAddress() {
		return numAddress;
	}

	public void setNumAddress(Integer numAddress) {
		this.numAddress = numAddress;
	}

	public String getIndAddressType() {
		return indAddressType;
	}

	public void setIndAddressType(String indAddressType) {
		this.indAddressType = indAddressType;
	}
	
	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}
	
	public PostalAreaEntity getPostalArea() {
		return postalArea;
	}

	public void setPostalArea(PostalAreaEntity postalArea) {
		this.postalArea = postalArea;
	}

	public String getDesAddressComplement() {
		return desAddressComplement;
	}

	public void setDesAddressComplement(String desAddressComplement) {
		this.desAddressComplement = desAddressComplement;
	}
	
	public PartnerEntity getPartner() {
		return partner;
	}

	public void setPartner(PartnerEntity partner) {
		this.partner = partner;
	}

	@Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdAddress() == null ? super.hashCode() : this.getIdAddress().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idAddress", idAddress)
                .add("postalAreaEntity", postalArea)
                .add("numAddress", numAddress)
                .add("desAddressComplement", desAddressComplement)
                .add("indAddressType", indAddressType)
                .add("signupDate", signupDate)
                .add("partner", partner)
                .toString();
    }
}
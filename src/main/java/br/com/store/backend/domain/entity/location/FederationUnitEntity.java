package br.com.store.backend.domain.entity.location;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "FEDERATION_UNIT")
public class FederationUnitEntity {
    
	@Id
	@Column(name = "ID_FEDERATION_UNIT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFederationUnit;
	
	@Column(name = "NAM_FEDERATION_UNIT")
	private String namFedarationUnit;
	
	@Column(name = "ABV_FEDERATION_UNIT")
	private String abvFederationUnit;
	
	@JoinColumn(name = "id_country")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private CountryEntity country;
    

	public Integer getIdFederationUnit() {
		return idFederationUnit;
	}

	public void setIdFederationUnit(Integer idFederationUnit) {
		this.idFederationUnit = idFederationUnit;
	}

	public String getNamFedarationUnit() {
		return namFedarationUnit;
	}

	public void setNamFedarationUnit(String namFedarationUnit) {
		this.namFedarationUnit = namFedarationUnit;
	}

	public String getAbvFederationUnit() {
		return abvFederationUnit;
	}

	public void setAbvFederationUnit(String abvFederationUnit) {
		this.abvFederationUnit = abvFederationUnit;
	}
	
	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	@Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdFederationUnit() == null ? super.hashCode() : this.getIdFederationUnit().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idFederationUnit", idFederationUnit)
                .add("namFedarationUnit", namFedarationUnit)
                .add("abvFederationUnit", abvFederationUnit)
                .add("country", country)
                .toString();
    }
}
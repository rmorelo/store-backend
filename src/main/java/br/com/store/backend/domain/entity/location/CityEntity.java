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
@Table(name = "CITY")
public class CityEntity {
    
	@Id
	@Column(name = "ID_CITY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCity;
	
	@JoinColumn(name = "id_federation_unit")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private FederationUnitEntity federationUnit;
	
	@Column(name = "NAM_CITY")
	private String namCity;
	
	@Column(name = "NAM_CITY_ORIGINAL")
	private String namCityOriginal;
	
	@Column(name = "COD_POSTAL_CITY")
	private String codPostalCity;

	@Column(name = "COD_IBGE")
	private String codIbge;
    
	public Integer getIdCity() {
		return idCity;
	}

	public void setIdCity(Integer idCity) {
		this.idCity = idCity;
	}

	public FederationUnitEntity getFederationUnit() {
		return federationUnit;
	}

	public void setFederationUnit(FederationUnitEntity federationUnit) {
		this.federationUnit = federationUnit;
	}

	public String getNamCity() {
		return namCity;
	}

	public void setNamCity(String namCity) {
		this.namCity = namCity;
	}

	public String getNamCityOriginal() {
		return namCityOriginal;
	}

	public void setNamCityOriginal(String namCityOriginal) {
		this.namCityOriginal = namCityOriginal;
	}

	public String getCodPostalCity() {
		return codPostalCity;
	}

	public void setCodPostalCity(String codPostalCity) {
		this.codPostalCity = codPostalCity;
	}

	public String getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(String codIbge) {
		this.codIbge = codIbge;
	}

	@Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdCity() == null ? super.hashCode() : this.getIdCity().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idCity", idCity)
                .add("federationUnit", federationUnit)
                .add("namCity", namCity)
                .add("namCityOriginal", namCityOriginal)
                .add("codPostalCity", codPostalCity)
                .add("codIbge", codIbge)
                .toString();
    }
}
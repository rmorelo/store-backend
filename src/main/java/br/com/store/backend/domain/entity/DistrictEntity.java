package br.com.store.backend.domain.entity;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "DISTRICT")
public class DistrictEntity {
    
	@Id
	@Column(name = "ID_DISTRICT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDistrict;
	
	@Column(name = "NAM_DISTRICT")
	private String namDistrict;
	
	@JoinColumn(name = "id_city")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CityEntity city;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DISTRICT_POSTAL_AREA", joinColumns = { @JoinColumn(name = "ID_DISTRICT") },
			inverseJoinColumns = { @JoinColumn(name = "ID_POSTAL_AREA") })
	private Set<DistrictEntity> postalArea;
	
	public Collection<DistrictEntity> getPostalArea() {
		return postalArea;
	}

	public void setPostalArea(Set<DistrictEntity> postalArea) {
		this.postalArea = postalArea;
	}

	public Integer getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(Integer idDistrict) {
		this.idDistrict = idDistrict;
	}

	public String getNamDistrict() {
		return namDistrict;
	}

	public void setNamDistrict(String namDistrict) {
		this.namDistrict = namDistrict;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	@Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdDistrict() == null ? super.hashCode() : this.getIdDistrict().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idDistrict", idDistrict)
                .add("namDistrict", namDistrict)
                .add("city", city)
                .toString();
    }
}
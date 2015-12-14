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
@Table(name = "POSTAL_AREA")
public class PostalAreaEntity {
    
	@Id
	@Column(name = "ID_POSTAL_AREA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPostalArea;
	
	@JoinColumn(name = "id_city")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CityEntity city;
	
	@Column(name = "NAM_POSTAL_AREA")
	private String namPostalArea;
	
	@Column(name = "COD_POSTAL_AREA")
	private String codPostalArea;
	
	@Column(name = "DES_SEGMENT")
	private String desSegment;
	
	@JoinColumn(name = "id_parent_postal_area")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PostalAreaEntity parentPostalArea;
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "DISTRICT_POSTAL_AREA", joinColumns = { @JoinColumn(name = "ID_POSTAL_AREA") },
			inverseJoinColumns = { @JoinColumn(name = "ID_DISTRICT") })
	private Set<DistrictEntity> district;
	
    public Collection<DistrictEntity> getDistrict() {
		return district;
	}

	public void setDistrict(Set<DistrictEntity> district) {
		this.district = district;
	}

	public Integer getIdPostalArea() {
		return idPostalArea;
	}

	public void setIdPostalArea(Integer idPostalArea) {
		this.idPostalArea = idPostalArea;
	}
	
	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	public String getNamPostalArea() {
		return namPostalArea;
	}

	public void setNamPostalArea(String namPostalArea) {
		this.namPostalArea = namPostalArea;
	}

	public String getCodPostalArea() {
		return codPostalArea;
	}

	public void setCodPostalArea(String codPostalArea) {
		this.codPostalArea = codPostalArea;
	}

	public String getDesSegment() {
		return desSegment;
	}

	public void setDesSegment(String desSegment) {
		this.desSegment = desSegment;
	}

	public PostalAreaEntity getParentPostalArea() {
		return parentPostalArea;
	}

	public void setParentPostalArea(
			PostalAreaEntity parentPostalArea) {
		this.parentPostalArea = parentPostalArea;
	}

	@Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdPostalArea() == null ? super.hashCode() : this.getIdPostalArea().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idPostalArea", idPostalArea)
                .add("city", city)
                .add("namPostalArea", namPostalArea)
                .add("codPostalArea", codPostalArea)
                .add("desSegment", desSegment)
                .add("parentPostalAreaEntity", parentPostalArea)
                .toString();
    }
}
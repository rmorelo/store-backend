package br.com.store.backend.domain.entity.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "COUNTRY")
public class CountryEntity {
    
	@Id
	@Column(name = "ID_COUNTRY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCountry;
	
	@Column(name = "NAM_COUNTRY")
	private String namCountry;
	
	@Column(name = "NAM_COUNTRY_ENGLISH")
	private String namCountryEnglish;
	
	@Column(name = "ABV2_COUNTRY")
	private String abv2Country;

	@Column(name = "ABV3_COUNTRY")
	private String abv3Country;
	
	@Column(name = "FLG_POSTAL_BASE")
	private Integer flgPostalBase;
	
	@Column(name = "NUM_DDI_COUNTRY")
	private String numDDICountry;
    
	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public String getNamCountry() {
		return namCountry;
	}

	public void setNamCountry(String namCountry) {
		this.namCountry = namCountry;
	}

	public String getNamCountryEnglish() {
		return namCountryEnglish;
	}

	public void setNamCountryEnglish(String namCountryEnglish) {
		this.namCountryEnglish = namCountryEnglish;
	}

	public String getAbv2Country() {
		return abv2Country;
	}

	public void setAbv2Country(String abv2Country) {
		this.abv2Country = abv2Country;
	}

	public String getAbv3Country() {
		return abv3Country;
	}

	public void setAbv3Country(String abv3Country) {
		this.abv3Country = abv3Country;
	}

	public Integer getFlgPostalBase() {
		return flgPostalBase;
	}

	public void setFlgPostalBase(Integer flgPostalBase) {
		this.flgPostalBase = flgPostalBase;
	}

	public String getNumDDICountry() {
		return numDDICountry;
	}

	public void setNumDDICountry(String numDDICountry) {
		this.numDDICountry = numDDICountry;
	}

	@Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdCountry() == null ? super.hashCode() : this.getIdCountry().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idCountry", idCountry)
                .add("namCountry", namCountry)
                .add("namCountryEnglish", namCountryEnglish)
                .add("abv2Country", abv2Country)
                .add("abv3Country", abv3Country)
                .add("flgPostalBase", flgPostalBase)
                .add("numDDICountry", numDDICountry)
                .toString();
    }
}
package br.com.store.backend.domain.entity.pet;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.store.backend.domain.entity.customer.CustomerEntity;

import com.google.common.base.Objects;

@Entity
@Table(name = "ANIMAL")
public class AnimalEntity {
    
	@Id
	@Column(name = "ID_ANIMAL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAnimal;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SEX")
	private String sex;
	
	@Column(name = "AGE")
	private Double age;
	
	@Column(name = "ADDITIONAL_INFO")
	private String addtionalInfo;
	
	@Column(name = "URL_PHOTO")
    private String urlPhoto;
		
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ANIMAL_BREED", joinColumns = { @JoinColumn(name = "ID_ANIMAL") },
			inverseJoinColumns = { @JoinColumn(name = "ID_BREED") })
	private Set<BreedEntity> breeds;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer")
	private CustomerEntity customer;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_weight")
	private WeightEntity weight;
	
	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getAddtionalInfo() {
        return addtionalInfo;
    }

    public void setAddtionalInfo(String addtionalInfo) {
        this.addtionalInfo = addtionalInfo;
    }

    public WeightEntity getWeight() {
        return weight;
    }

    public void setWeight(WeightEntity weight) {
        this.weight = weight;
    }

    public Set<BreedEntity> getBreeds() {
		return breeds;
	}

	public void setBreeds(Set<BreedEntity> breeds) {
		this.breeds = breeds;
	}
	
	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdAnimal() == null ? super.hashCode() : this.getIdAnimal().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idAnimal", idAnimal)
                .add("name", name)
                .add("sex", sex)
                .add("weight", weight)
                .add("age", age)
                .add("addtionalInfo", addtionalInfo)
                .add("breeds", breeds)
                .add("customer", customer)
                .add("urlPhoto", urlPhoto)
                .toString();
    }
}
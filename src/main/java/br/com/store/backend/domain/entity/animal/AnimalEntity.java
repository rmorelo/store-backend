package br.com.store.backend.domain.entity.animal;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
	
	@Column(name = "WEIGHT")
	private Integer weight;
	
	@Column(name = "HEIGHT")
	private Integer height;
	
	@Column(name = "WIDTH")
	private Integer width;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ANIMAL_BREED", joinColumns = { @JoinColumn(name = "ID_ANIMAL") },
			inverseJoinColumns = { @JoinColumn(name = "ID_BREED") })
	private Set<BreedEntity> breeds;
	
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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Set<BreedEntity> getBreeds() {
		return breeds;
	}

	public void setBreeds(Set<BreedEntity> breeds) {
		this.breeds = breeds;
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
                .add("height", height)
                .add("width", width)
                .add("breeds", breeds)
                .toString();
    }
}
package br.com.store.backend.domain.entity.animal;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.google.common.base.Objects;

@Entity
@Table(name = "BREED")
public class BreedEntity {
    
	@Id
	@Column(name = "ID_BREED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBreed;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_species")
	private SpeciesEntity species;
	
	@ManyToMany(mappedBy = "breeds", fetch = FetchType.LAZY)
	private Set<AnimalEntity> animals;

	public Integer getIdBreed() {
		return idBreed;
	}

	public void setIdBreed(Integer idBreed) {
		this.idBreed = idBreed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SpeciesEntity getSpecies() {
		return species;
	}

	public void setSpecies(SpeciesEntity species) {
		this.species = species;
	}
	
	public Set<AnimalEntity> getAnimals() {
		return animals;
	}

	public void setAnimals(Set<AnimalEntity> animals) {
		this.animals = animals;
	}

	@Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdBreed() == null ? super.hashCode() : this.getIdBreed().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idBreed", idBreed)
                .add("description", description)
                .add("species", species)
                .add("animals", animals)
                .toString();
    }
}
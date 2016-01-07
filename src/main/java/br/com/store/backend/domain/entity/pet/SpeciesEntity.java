package br.com.store.backend.domain.entity.pet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "SPECIES")
public class SpeciesEntity {
    
	@Id
	@Column(name = "ID_SPECIES")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSpecies;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_group")
	private GroupEntity group;
	
	@OneToMany(mappedBy = "species", fetch = FetchType.LAZY)
	private Set<BreedEntity> breeds;
	
	public Integer getIdSpecies() {
		return idSpecies;
	}

	public void setIdSpecies(Integer idSpecies) {
		this.idSpecies = idSpecies;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupEntity getGroup() {
		return group;
	}

	public void setGroup(GroupEntity group) {
		this.group = group;
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
        return this.getIdSpecies() == null ? super.hashCode() : this.getIdSpecies().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idSpecies", idSpecies)
                .add("name", name)
                .add("group", group)
                .toString();
    }
}
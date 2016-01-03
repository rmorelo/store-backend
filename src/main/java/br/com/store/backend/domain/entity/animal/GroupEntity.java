package br.com.store.backend.domain.entity.animal;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "GROUP")
public class GroupEntity {
    
	@Id
	@Column(name = "ID_GROUP")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGroup;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private Set<SpeciesEntity> species;
	
	public Integer getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(Integer idGroup) {
		this.idGroup = idGroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<SpeciesEntity> getSpecies() {
		return species;
	}

	public void setSpecies(Set<SpeciesEntity> species) {
		this.species = species;
	}

	@Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdGroup() == null ? super.hashCode() : this.getIdGroup().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idGroup", idGroup)
                .add("description", description)
                .add("species", species)
                .toString();
    }
}
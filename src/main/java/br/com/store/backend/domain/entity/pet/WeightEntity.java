package br.com.store.backend.domain.entity.pet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "GROUP")
public class WeightEntity {
    
	@Id
	@Column(name = "ID_WEIGHT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idWeight;
	
	@Column(name = "WEIGHT_RANGE")
	private String weightRange;
	
	@OneToOne(mappedBy = "weight", fetch = FetchType.LAZY)
	private AnimalEntity animal;
	
	public Integer getIdWeight() {
        return idWeight;
    }

    public void setIdWeight(Integer idWeight) {
        this.idWeight = idWeight;
    }

    public String getWeightRange() {
        return weightRange;
    }

    public void setWeightRange(String weightRange) {
        this.weightRange = weightRange;
    }

    public AnimalEntity getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalEntity animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj != null && this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        return this.getIdWeight() == null ? super.hashCode() : this.getIdWeight().hashCode();
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("idWeight", idWeight)
                .add("weightRange", weightRange)
                .add("animal", animal)
                .toString();
    }
}
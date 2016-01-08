package br.com.store.backend.domain.service.pet;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import br.com.store.backend.domain.AbstractServiceMapper;
import br.com.store.backend.domain.entity.pet.BreedEntity;
import br.com.store.backend.view.resource.pet.Breed;

@Component
public class BreedServiceMapper extends AbstractServiceMapper {

	private ModelMapper modelMapper;
	
	public BreedServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	}

	public Breed mapBreedEntityToBreed(BreedEntity breedEntity) {
		if(breedEntity == null) {
			return null;
		}

		Breed breed = map(breedEntity, Breed.class);
		return breed;
	}
	
	public void mapBreedToBreedEntity(Breed breed, BreedEntity breedEntity) {
		if(breed == null) {
			return;
		}

		map(breed, breedEntity);
	}
	
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}

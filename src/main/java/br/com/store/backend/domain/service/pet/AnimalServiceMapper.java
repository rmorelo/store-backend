package br.com.store.backend.domain.service.pet;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import br.com.store.backend.domain.AbstractServiceMapper;
import br.com.store.backend.domain.entity.pet.AnimalEntity;
import br.com.store.backend.view.resource.pet.Animal;

@Component
public class AnimalServiceMapper extends AbstractServiceMapper {

	private ModelMapper modelMapper;
	
	public AnimalServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	}

	public Animal mapAnimalEntityToAnimal(AnimalEntity animalEntity) {
		if(animalEntity == null) {
			return null;
		}

		Animal animal = map(animalEntity, Animal.class);
		return animal;
	}
	
	public void mapAnimalToAnimalEntity(Animal animal, AnimalEntity animalEntity) {
		if(animal == null) {
			return;
		}

		map(animal, animalEntity);
	}
	
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}

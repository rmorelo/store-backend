package br.com.store.backend.domain.service.person;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.store.backend.domain.AbstractServiceMapper;
import br.com.store.backend.domain.entity.person.IndividualEntity;
import br.com.store.backend.view.resource.person.Individual;

@Component
public class IndividualServiceMapper extends AbstractServiceMapper {

	private ModelMapper modelMapper;
	
	public IndividualServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	}

	public Individual mapIndividualEntityToIndividual(IndividualEntity individualEntity) {
		if(individualEntity == null) {
			return null;
		}

		Individual individual = map(individualEntity, Individual.class);
		return individual;
	}
	
	public void mapIndividualToIndividualEntity(Individual individual, IndividualEntity individualEntity) {
		if(individual == null) {
			return;
		}

		map(individual, individualEntity);
	}
	
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}

package br.com.store.backend.domain.service.pet;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import br.com.store.backend.domain.AbstractServiceMapper;
import br.com.store.backend.domain.entity.pet.WeightEntity;
import br.com.store.backend.view.resource.pet.Weight;

@Component
public class WeightServiceMapper extends AbstractServiceMapper {

	private ModelMapper modelMapper;
	
	public WeightServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	}

	public Weight mapWeightEntityToWeight(WeightEntity weightEntity) {
		if(weightEntity == null) {
			return null;
		}

		Weight weight = map(weightEntity, Weight.class);
		return weight;
	}
	
	public void mapWeightToWeightEntity(Weight weight, WeightEntity weightEntity) {
		if(weight == null) {
			return;
		}

		map(weight, weightEntity);
	}
	
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}

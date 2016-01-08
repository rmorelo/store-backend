package br.com.store.backend.domain.service.pet;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import br.com.store.backend.domain.AbstractServiceMapper;
import br.com.store.backend.domain.entity.pet.GroupEntity;
import br.com.store.backend.view.resource.pet.Group;

@Component
public class GroupServiceMapper extends AbstractServiceMapper {

	private ModelMapper modelMapper;
	
	public GroupServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	}

	public Group mapGroupEntityToGroup(GroupEntity groupEntity) {
		if(groupEntity == null) {
			return null;
		}

		Group group = map(groupEntity, Group.class);
		return group;
	}
	
	public void mapGroupToGroupEntity(Group group, GroupEntity groupEntity) {
		if(group == null) {
			return;
		}

		map(group, groupEntity);
	}
	
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}

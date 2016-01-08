package br.com.store.backend.domain.service.pet;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.pet.GroupEntity;
import br.com.store.backend.domain.repository.pet.GroupRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Group;

@Service
@Transactional(readOnly = true)
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;
    
    @Resource
	private GroupServiceMapper groupServiceMapper;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Group findGroup(Integer idGroup) {
        GroupEntity groupEntity = groupRepository.findOne(idGroup);
    	
    	if(groupEntity == null){
    		throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);
    	}
    	
    	return GroupConverter.convert(groupEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Collection<Group> findGroups() {
    	Collection<GroupEntity> groupEntities = groupRepository.findAll();
    	
    	if(groupEntities == null || groupEntities.isEmpty()){
    		throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);
    	}
        
        Collection<Group> groups = new ArrayList<Group>();

        for (GroupEntity groupEntity : groupEntities){
            Group group = GroupConverter.convert(groupEntity);
            groups.add(group);
        }
        
        return groups;
    }
    
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Group saveGroup(Group group) {
    	GroupEntity groupEntity = GroupConverter.convert(group);       
    	groupEntity = groupRepository.save(groupEntity);
        return GroupConverter.convert(groupEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Group update(Group group) {    	
    	GroupEntity groupEntity = groupRepository.findOne(group.getIdGroup());
    	
    	if(groupEntity == null){
    		throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);
    	}
    	
    	groupServiceMapper.mapGroupToGroupEntity(group, groupEntity);
    	GroupEntity groupEntitySaved = groupRepository.save(groupEntity);
        return GroupConverter.convert(groupEntitySaved);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public void delete(Integer idGroup) {
    	GroupEntity groupEntity = groupRepository.findOne(idGroup);
    	
    	if(groupEntity == null){
    		throw new NotFoundException(NotFoundException.WEIGHT_NOT_FOUND);
    	}
    	
        groupRepository.delete(groupEntity.getIdGroup());        
    }
    
}

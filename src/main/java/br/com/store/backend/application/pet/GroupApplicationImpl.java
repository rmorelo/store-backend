package br.com.store.backend.application.pet;

import java.util.Collection;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.service.pet.GroupService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Group;

@Service
@Transactional(readOnly = true)
public class GroupApplicationImpl implements GroupApplication {

    @Autowired
    private GroupService groupService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Group findGroup(Integer idGroup) {
    	return groupService.findGroup(idGroup);
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Collection<Group> findGroups() {
    	return groupService.findGroups();
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Group saveGroup(Group group) {
        return groupService.saveGroup(group);
    }
    
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Group update(Group group) {
        return groupService.update(group);
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public void delete(Integer idGroup) {
        groupService.delete(idGroup);
    }
		
}

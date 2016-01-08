package br.com.store.backend.application.pet;

import java.util.Collection;
import br.com.store.backend.view.resource.pet.Group;

public interface GroupApplication {
    
    Group findGroup(Integer idGroup);
    
    Collection<Group> findGroups();
    
    Group saveGroup(Group group);
    
    Group update(Group group);
        
    void delete(Integer idGroup);
    
}

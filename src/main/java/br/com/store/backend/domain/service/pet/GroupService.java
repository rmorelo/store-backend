package br.com.store.backend.domain.service.pet;

import java.util.Collection;

import br.com.store.backend.view.resource.pet.Group;

public interface GroupService {
  
    Group findGroup(Integer idGroup);
    
    Collection<Group> findGroups();
    
    Group findGroupBySpecies(Integer idSpecies);
    
    Group saveGroup(Group group);
    
    Group update(Group group);
    
    void delete(Integer idGroup);
}

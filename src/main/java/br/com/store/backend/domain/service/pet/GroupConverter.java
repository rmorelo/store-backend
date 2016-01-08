package br.com.store.backend.domain.service.pet;

import org.springframework.beans.BeanUtils;

import br.com.store.backend.domain.entity.pet.GroupEntity;
import br.com.store.backend.view.resource.pet.Group;

public class GroupConverter {

    private GroupConverter() {
    }

    public static Group convert(GroupEntity entity) {
        if (entity == null) {
        	return null;
        }
        Group group = new Group();
        BeanUtils.copyProperties(entity, group);

        return group;
    }
    
    public static GroupEntity convert(Group group) {
        if (group == null) {
        	return null;
        }
        GroupEntity entity = new GroupEntity();
        BeanUtils.copyProperties(group, entity);
        
        return entity;
    }
    
}

package br.com.store.backend.domain.service.person;

import org.springframework.beans.BeanUtils;

import br.com.store.backend.domain.entity.person.IndividualEntity;
import br.com.store.backend.view.resource.person.Individual;

public class IndividualConverter {

    private IndividualConverter() {
    }

    public static Individual convert(IndividualEntity entity) {
        if (entity == null) {
        	return null;
        }
        
        Individual individual = new Individual();
        BeanUtils.copyProperties(entity, individual);
        
        return individual;
    }
    
    public static IndividualEntity convert(Individual individual) {
        if (individual == null) {
        	return null;
        }
        IndividualEntity entity = new IndividualEntity();
        BeanUtils.copyProperties(individual, entity);
        
        return entity;
    }
    
}

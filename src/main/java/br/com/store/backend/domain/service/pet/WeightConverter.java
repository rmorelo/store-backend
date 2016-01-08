package br.com.store.backend.domain.service.pet;

import org.springframework.beans.BeanUtils;

import br.com.store.backend.domain.entity.pet.WeightEntity;
import br.com.store.backend.view.resource.pet.Weight;

public class WeightConverter {

    private WeightConverter() {
    }

    public static Weight convert(WeightEntity entity) {
        if (entity == null) {
        	return null;
        }
        Weight weight = new Weight();
        BeanUtils.copyProperties(entity, weight);

        return weight;
    }
    
    public static WeightEntity convert(Weight weight) {
        if (weight == null) {
        	return null;
        }
        WeightEntity entity = new WeightEntity();
        BeanUtils.copyProperties(weight, entity);
        
        return entity;
    }
    
}

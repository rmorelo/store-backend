package br.com.store.backend.domain.service.pet;

import org.springframework.beans.BeanUtils;
import br.com.store.backend.domain.entity.pet.BreedEntity;
import br.com.store.backend.view.resource.pet.Breed;

public class BreedConverter {

    private BreedConverter() {
    }

    public static Breed convert(BreedEntity entity) {
        if (entity == null) {
        	return null;
        }
        Breed breed = new Breed();
        BeanUtils.copyProperties(entity, breed, "animals");

        return breed;
    }
    
    public static BreedEntity convert(Breed breed) {
        if (breed == null) {
        	return null;
        }
        BreedEntity entity = new BreedEntity();
        BeanUtils.copyProperties(breed, entity);
        
        return entity;
    }
    
}

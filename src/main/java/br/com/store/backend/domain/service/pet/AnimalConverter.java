package br.com.store.backend.domain.service.pet;

import org.springframework.beans.BeanUtils;

import br.com.store.backend.domain.entity.pet.AnimalEntity;
import br.com.store.backend.view.resource.pet.Animal;

public class AnimalConverter {

    private AnimalConverter() {
    }

    public static Animal convert(AnimalEntity entity) {
        if (entity == null) {
        	return null;
        }
        Animal animal = new Animal();
        BeanUtils.copyProperties(entity, animal, "breeds");

        return animal;
    }
    
    public static AnimalEntity convert(Animal animal) {
        if (animal == null) {
        	return null;
        }
        AnimalEntity entity = new AnimalEntity();
        BeanUtils.copyProperties(animal, entity);
        
        return entity;
    }
    
}

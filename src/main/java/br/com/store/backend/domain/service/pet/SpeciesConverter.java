package br.com.store.backend.domain.service.pet;

import org.springframework.beans.BeanUtils;

import br.com.store.backend.domain.entity.pet.SpeciesEntity;
import br.com.store.backend.view.resource.pet.Species;

public class SpeciesConverter {

    private SpeciesConverter() {
    }

    public static Species convert(SpeciesEntity entity) {
        if (entity == null) {
        	return null;
        }
        Species species = new Species();
        BeanUtils.copyProperties(entity, species);

        return species;
    }
    
    public static SpeciesEntity convert(Species species) {
        if (species == null) {
        	return null;
        }
        SpeciesEntity entity = new SpeciesEntity();
        BeanUtils.copyProperties(species, entity);
        
        return entity;
    }
    
}

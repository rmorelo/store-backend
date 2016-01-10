package br.com.store.backend.domain.service.pet;

import java.util.Collection;
import br.com.store.backend.view.resource.pet.Weight;

public interface WeightService {
  
    Weight findWeight(Integer idWeight);
    
    Collection<Weight> findWeights();
    
    Weight findWeightByAnimal(Integer idAnimal);
    
    Weight saveWeight(Weight weight);
    
    Weight update(Weight weight);
    
    void delete(Integer idWeight);
}

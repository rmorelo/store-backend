package br.com.store.backend.application.pet;

import java.util.Collection;
import br.com.store.backend.view.resource.pet.Weight;

public interface WeightApplication {
    
    Weight findWeight(Integer idWeight);
    
    Collection<Weight> findWeights();
    
    Weight saveWeight(Weight weight);
    
    Weight update(Weight weight);
        
    void delete(Integer idWeight);
    
}

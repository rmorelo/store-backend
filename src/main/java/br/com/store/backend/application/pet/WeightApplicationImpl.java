package br.com.store.backend.application.pet;

import java.util.Collection;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.service.pet.WeightService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.pet.Weight;

@Service
@Transactional(readOnly = true)
public class WeightApplicationImpl implements WeightApplication {

    @Autowired
    private WeightService weightService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Weight findWeight(Integer idWeight) {
    	return weightService.findWeight(idWeight);
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Collection<Weight> findWeights() {
    	return weightService.findWeights();
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Weight saveWeight(Weight weight) {
        return weightService.saveWeight(weight);
    }
    
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Weight update(Weight weight) {
        return weightService.update(weight);
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public void delete(Integer idWeight) {
        weightService.delete(idWeight);
    }
		
}

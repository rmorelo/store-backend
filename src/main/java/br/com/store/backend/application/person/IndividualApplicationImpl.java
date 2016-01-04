package br.com.store.backend.application.person;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.store.backend.domain.service.person.IndividualService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.person.Individual;

@Service
public class IndividualApplicationImpl implements IndividualApplication {

    @Autowired
    private IndividualService individualService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Individual findIndividualByPartner(Integer idPartner) {    	
    	 return individualService.findIndividualByPartner(idPartner);
    }
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Individual findIndividual(Integer idIndividual) {    	
    	 return individualService.findIndividual(idIndividual);
    }

	@Override
    @Profiled(level = Profiling.APPLICATION)
	public Individual saveIndividualOfPartner(Integer idPartner, Individual individual) {
		return individualService.saveIndividualOfPartner(idPartner, individual);
	}
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public Individual update(Individual individual) {
        return individualService.update(individual);
    }
	
	@Override
    @Profiled(level = Profiling.APPLICATION)
    public void delete(Integer idIndividual) {
		individualService.delete(idIndividual);
    }

}

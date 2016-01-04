package br.com.store.backend.domain.service.person;

import br.com.store.backend.view.resource.person.Individual;

public interface IndividualService {
  
	Individual findIndividualByPartner(Integer idPartner);
	
	Individual findIndividualByCustomer(Integer idCustomer);
	
	Individual findIndividual(Integer idIndividual);
    
    Individual save(Individual individual);
    
    Individual update(Individual individual);
  
    void delete(Integer idIndividual);
}

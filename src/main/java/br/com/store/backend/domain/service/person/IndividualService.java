package br.com.store.backend.domain.service.person;

import br.com.store.backend.view.resource.person.Individual;

public interface IndividualService {
  
	Individual findIndividualByPartner(Integer idPartner);
	
	Individual findIndividual(Integer idIndividual);
    
    Individual saveIndividualOfPartner(Integer idPartner, Individual individual);
    
    Individual update(Individual individual);
  
    void delete(Integer idIndividual);
}

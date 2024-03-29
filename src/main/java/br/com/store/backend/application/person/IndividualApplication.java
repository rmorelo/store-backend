package br.com.store.backend.application.person;

import br.com.store.backend.view.resource.person.Individual;

public interface IndividualApplication {
    
	Individual findIndividualByPartner(Integer idPartner);

	Individual findIndividual(Integer idIndividual);
	
	Individual saveIndividualOfPartner(Integer idPartner, Individual individual);
	
	Individual saveIndividualOfCustomer(Integer idCustomer, Individual individual);
    
    Individual update(Individual individual);

    void delete(Integer idIndividual);
    
}

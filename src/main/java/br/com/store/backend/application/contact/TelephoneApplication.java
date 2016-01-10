package br.com.store.backend.application.contact;

import br.com.store.backend.view.resource.contact.Telephone;

public interface TelephoneApplication {
 
	Telephone saveTelephoneOfPartner(Integer idPartner, Telephone telephone);
	
	Telephone saveTelephoneOfCustomer(Integer idCustomer, Telephone telephone);
	
	Telephone findTelephoneByCustomer(Integer idCustomer);
	
	Telephone findTelephoneByPartner(Integer idPartner);
	
}

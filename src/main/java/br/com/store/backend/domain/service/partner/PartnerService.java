package br.com.store.backend.domain.service.partner;

import br.com.store.backend.view.resource.partner.Company;
import br.com.store.backend.view.resource.partner.Individual;
import br.com.store.backend.view.resource.partner.Partner;

public interface PartnerService {
  
    Partner findByIdPartner(Integer idPartner);
    
    Company save(Company company);
    
    Individual save(Individual individual);
    
    Partner update(Partner partner);
            
    void delete(Integer idPartner);
}

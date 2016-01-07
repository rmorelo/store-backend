package br.com.store.backend.domain.service.partner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.store.backend.view.resource.partner.Partner;

public interface PartnerService {
  
    Partner findPartner(Integer idPartner);
    
    Page<Partner> findPartnersByCustomer(Integer idCustomer, Pageable pageable);
    
    Partner save(Partner partner);
    
    Partner update(Partner partner);
    
    Partner updateCustomerOfPartner(Integer idPartner, Integer idCustomer);
    
    void delete(Integer idPartner);
}

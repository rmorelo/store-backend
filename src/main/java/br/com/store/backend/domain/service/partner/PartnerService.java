package br.com.store.backend.domain.service.partner;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import br.com.store.backend.view.resource.partner.Partner;

public interface PartnerService {
  
    Partner findPartner(Integer idPartner);
    
    Collection<Partner> findPartnersByCustomer(Integer idCustomer, Pageable pageable);
    
    Partner save(Partner partner);
    
    Partner update(Partner partner);
    
    void delete(Integer idPartner);
}

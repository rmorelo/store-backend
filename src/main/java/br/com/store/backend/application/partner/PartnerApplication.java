package br.com.store.backend.application.partner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.store.backend.view.resource.partner.Partner;

public interface PartnerApplication {
    
    Partner findPartner(Integer idPartner, String[] selectors);
    
    Page<Partner> findPartnersByIdCustomer(Integer idCustomer, Pageable pageable);
    
    Partner save(Partner partner);
    
    Partner update(Partner partner);
    
    void delete(Integer idPartner);
    
}

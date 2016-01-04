package br.com.store.backend.application.partner;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import br.com.store.backend.view.resource.partner.Partner;

public interface PartnerApplication {
    
    Partner findPartner(Integer idPartner, String[] selectors);
    
    Collection<Partner> findPartnersByIdCustomer(Integer idCustomer, Pageable pageable);
    
    Partner save(Partner partner);
    
    Partner update(Partner partner);
    
    void delete(Integer idPartner);
    
}

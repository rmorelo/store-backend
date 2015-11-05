package br.com.store.backend.application.partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.partner.PartnerService;
import br.com.store.backend.infrastructure.exception.InternalServerErrorException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.RestClientException;
import br.com.store.backend.view.resource.partner.Partner;

@Service
public class PartnerApplicationImpl implements PartnerApplication {

    @Autowired
    private PartnerService partnerService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Partner getPartner(Integer idPartner) {
        try {
            return partnerService.getPartner(idPartner);
        } catch (RestClientException e) {
            throw new InternalServerErrorException();
        }
    }

}

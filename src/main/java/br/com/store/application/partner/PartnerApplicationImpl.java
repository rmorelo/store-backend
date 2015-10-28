package br.com.store.application.partner;

import org.apache.log4j.Logger;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.domain.service.partner.PartnerService;
import br.com.store.infrastructure.exception.InternalServerErrorException;
import br.com.store.infrastructure.profiling.Profiling;
import br.com.store.infrastructure.rest.RestClientException;
import br.com.store.infrastructure.tracking.Tracker;
import br.com.store.view.resource.partner.Partner;

@Service
public class PartnerApplicationImpl implements PartnerApplication {

    private static final int NOT_FOUND = 404;
    private static Logger logger = Logger.getLogger(PartnerApplicationImpl.class);
    @Autowired
    private PartnerService partnerService;

    @Override
    @Profiled(level = Profiling.APPLICATION)
    public Partner getPartner() {
        try {
            return partnerService.getPartner(Long.valueOf(Tracker.getString(Tracker.ID_PARTNER)));
        } catch (RestClientException e) {
            throw new InternalServerErrorException();
        }
    }

}

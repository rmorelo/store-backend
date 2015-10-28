package br.com.store.domain.service.partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.domain.entity.PartnerEntity;
import br.com.store.domain.repository.partner.PartnerRepository;
import br.com.store.infrastructure.profiling.Profiling;
import br.com.store.infrastructure.rest.RestClientException;
import br.com.store.view.resource.partner.Partner;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository restRepository;

    @Profiled(level = Profiling.SERVICE)
    @Override
    public Partner getPartner(Long idPartner) throws RestClientException {
        PartnerEntity partnerEntity = restRepository.getPartner(idPartner);
        return convert(partnerEntity);

    }

    @Profiled(level = Profiling.SERVICE)
    @Override
    public Partner getPartner(String name) throws RestClientException {
        PartnerEntity partnerEntity = restRepository.getPartner(name);
        return convert(partnerEntity);

    }

    private Partner convert(PartnerEntity entity) {
        if (entity == null) {
            return null;
        }
        return PartnerConverter.convert(entity);
    }
    
}

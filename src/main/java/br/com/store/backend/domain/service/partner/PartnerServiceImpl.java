package br.com.store.backend.domain.service.partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.entity.PartnerEntity;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Partner;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Profiled(level = Profiling.SERVICE)
    @Override
    public Partner findByIdPartner(Integer idPartner) {
    	PartnerEntity partnerEntity = partnerRepository.findByIdPartner(idPartner);
    	return PartnerConverter.convert(partnerEntity);
    }
    
    @Override
	public Partner savePartner(Partner partner) {
    	PartnerEntity partnerEntity = partnerRepository.saveAndFlush(PartnerConverter.convert(partner));
    	return PartnerConverter.convert(partnerEntity);
	}	
    
}

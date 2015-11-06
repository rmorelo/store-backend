package br.com.store.backend.domain.service.partner;

import java.util.Date;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.PartnerEntity;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Partner;

@Service
@Transactional(readOnly = true)
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
    @Transactional
	public Partner save(Partner partner) {
        partner.setSignupDate(new Date());
        PartnerEntity partnerEntity = PartnerConverter.convert(partner);
        partnerEntity = partnerRepository.saveAndFlush(partnerEntity);
    	return PartnerConverter.convert(partnerEntity);
	}	
    
}

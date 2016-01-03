package br.com.store.backend.domain.service.partner;

import java.util.Date;
import javax.annotation.Resource;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Partner;

@Service
@Transactional(readOnly = true)
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;
    
    @Resource
	private PartnerServiceMapper partnerServiceMapper;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Partner findPartner(Integer idPartner) {
    	PartnerEntity partnerEntity = partnerRepository.findOne(idPartner);
    	
    	if(partnerEntity == null){
    		throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
    	}
    	
    	return PartnerConverter.convert(partnerEntity);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Partner save(Partner partner) {
    	partner.setSignupDate(new Date());
    	PartnerEntity partnerEntity = PartnerConverter.convert(partner);
    	partnerEntity = partnerRepository.save(partnerEntity);
    	return PartnerConverter.convert(partnerEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Partner update(Partner partner) {
    	partner.setSignupDate(new Date());
    	
    	PartnerEntity partnerEntity = partnerRepository.findOne(partner.getIdPartner());
    	
    	if(partnerEntity == null){
    		throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
    	}
    	
    	partnerServiceMapper.mapPartnerToPartnerEntity(partner, partnerEntity);
    	PartnerEntity partnerEntitySaved = partnerRepository.save(partnerEntity);
        return PartnerConverter.convert(partnerEntitySaved);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public void delete(Integer idPartner) {
    	PartnerEntity partnerEntity = partnerRepository.findOne(idPartner);
    	
    	if(partnerEntity == null){
    		throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
    	}
    	
        partnerRepository.delete(partnerEntity.getIdPartner());        
    }
    
}

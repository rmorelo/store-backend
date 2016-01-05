package br.com.store.backend.domain.service.partner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.domain.repository.customer.CustomerRepository;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Partner;

@Service
@Transactional(readOnly = true)
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
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
    @Profiled(level = Profiling.SERVICE)
    public Collection<Partner> findPartnersByCustomer(Integer idCustomer, Pageable pageable) {
        CustomerEntity customerEntity = customerRepository.findOne(idCustomer);
        
        if(customerEntity == null){
            throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
        }
        
        Collection<Partner> partners = new ArrayList<Partner>();
        Page<PartnerEntity> partnerEntities = partnerRepository.findAllByCustomers(customerEntity, pageable);
        
        for (PartnerEntity partnerEntity : partnerEntities){
            Partner partner = PartnerConverter.convert(partnerEntity);
            partners.add(partner);
        }
        
        return partners;
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

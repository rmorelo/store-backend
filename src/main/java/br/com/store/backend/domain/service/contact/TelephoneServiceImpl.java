package br.com.store.backend.domain.service.contact;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.ConfirmationStatusEnum;
import br.com.store.backend.domain.entity.contact.TelephoneEntity;
import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.domain.repository.contact.TelephoneRepository;
import br.com.store.backend.domain.repository.customer.CustomerRepository;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.contact.Telephone;

@Service
@Transactional(readOnly = true)
public class TelephoneServiceImpl implements TelephoneService {

    @Autowired
    private TelephoneRepository telephoneRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private PartnerRepository partnerRepository;
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Telephone save(Telephone telephone){
    	telephone.setConfirmation(ConfirmationStatusEnum.PENDING.getStatus());
        TelephoneEntity telephoneEntity = TelephoneConverter.convert(telephone);
        telephoneEntity = telephoneRepository.save(telephoneEntity);
        return TelephoneConverter.convert(telephoneEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Telephone findTelephoneByCustomer(Integer idCustomer){
    	CustomerEntity customerEntity = customerRepository.findOne(idCustomer);
    	
    	if(customerEntity == null){
    		throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
    	}
    	
    	TelephoneEntity telephoneEntity = customerEntity.getTelephone();
    	
    	if(telephoneEntity == null){
    		throw new NotFoundException(NotFoundException.TELEPHONE_NOT_FOUND);
    	}
    	
        return TelephoneConverter.convert(telephoneEntity);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Telephone findTelephoneByPartner(Integer idPartner){
    	PartnerEntity partnerEntity = partnerRepository.findOne(idPartner);
    	
    	if(partnerEntity == null){
    		throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
    	}
    	
    	TelephoneEntity telephoneEntity = partnerEntity.getTelephone();
    	
    	if(telephoneEntity == null){
    		throw new NotFoundException(NotFoundException.TELEPHONE_NOT_FOUND);
    	}
    	
        return TelephoneConverter.convert(telephoneEntity);
    }

}

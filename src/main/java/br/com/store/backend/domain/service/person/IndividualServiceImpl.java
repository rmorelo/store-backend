package br.com.store.backend.domain.service.person;

import java.util.Date;

import javax.annotation.Resource;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.customer.CustomerEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.domain.entity.person.IndividualEntity;
import br.com.store.backend.domain.repository.customer.CustomerRepository;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.domain.repository.person.IndividualRepository;
import br.com.store.backend.domain.service.person.IndividualConverter;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.person.Individual;

@Service
@Transactional(readOnly = true)
public class IndividualServiceImpl implements IndividualService {

    @Autowired
    private IndividualRepository individualRepository;
    
    @Autowired
    private PartnerRepository partnerRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Resource
    private IndividualServiceMapper individualServiceMapper;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Individual findIndividualByPartner(Integer idPartner) {
    	PartnerEntity partnerEntity = partnerRepository.findOne(idPartner);
    	
    	if(partnerEntity == null){
    		throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
    	}
    	
    	IndividualEntity individualEntity = partnerEntity.getIndividual();
    	
    	if(individualEntity == null){
    		throw new NotFoundException(NotFoundException.INDIVIDUAL_NOT_FOUND);
    	}
    	
    	return IndividualConverter.convert(individualEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Individual findIndividualByCustomer(Integer idCustomer) {
        CustomerEntity customerEntity = customerRepository.findOne(idCustomer);
        
        if(customerEntity == null){
            throw new NotFoundException(NotFoundException.CUSTOMER_NOT_FOUND);
        }
        
        IndividualEntity individualEntity = customerEntity.getIndividual();
        
        if(individualEntity == null){
            throw new NotFoundException(NotFoundException.INDIVIDUAL_NOT_FOUND);
        }
        
        return IndividualConverter.convert(individualEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Individual findIndividual(Integer idIndividual) {
    	IndividualEntity individualEntity = individualRepository.findOne(idIndividual);
    	
    	if(individualEntity == null){
    		throw new NotFoundException(NotFoundException.INDIVIDUAL_NOT_FOUND);
    	}
    	
    	return IndividualConverter.convert(individualEntity);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Individual save(Individual individual) {
    	individual.setSignupDate(new Date());
        IndividualEntity individualEntity = IndividualConverter.convert(individual);
        individualEntity = individualRepository.save(individualEntity);        
    	return IndividualConverter.convert(individualEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Individual update(Individual individual) {
    	IndividualEntity individualEntity = individualRepository.findOne(individual.getIdIndividual());
    	
    	if(individualEntity == null){
    		throw new NotFoundException(NotFoundException.INDIVIDUAL_NOT_FOUND);
    	}
    	
    	individualServiceMapper.mapIndividualToIndividualEntity(individual, individualEntity);
    	IndividualEntity individualEntitySaved = individualRepository.save(individualEntity);
        return IndividualConverter.convert(individualEntitySaved);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public void delete(Integer idIndividual) {
    	IndividualEntity individualEntity = individualRepository.findOne(idIndividual);
    	
    	if(individualEntity == null){
    		throw new NotFoundException(NotFoundException.INDIVIDUAL_NOT_FOUND);
    	}
    	
    	individualRepository.delete(individualEntity.getIdIndividual());        
    }
    
}

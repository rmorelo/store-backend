package br.com.store.backend.domain.service.partner;

import java.util.Date;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.partner.CompanyEntity;
import br.com.store.backend.domain.entity.partner.IndividualEntity;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.domain.entity.partner.PartnerTypeEnum;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Company;
import br.com.store.backend.view.resource.partner.Individual;
import br.com.store.backend.view.resource.partner.Partner;

@Service
@Transactional(readOnly = true)
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Partner findByIdPartner(Integer idPartner) {
    	PartnerEntity partnerEntity = partnerRepository.findByIdPartner(idPartner);
    	CompanyEntity companyEntity = null;
    	IndividualEntity individualEntity = null;
    	
    	if(partnerEntity == null){
    		throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
    	}
    	
    	if(partnerEntity.getPartnerType().equals(PartnerTypeEnum.PESSOA_JURIDICA.getType())){
    		companyEntity = (CompanyEntity)partnerEntity;
    		return CompanyConverter.convert(companyEntity); 
    	} else if(partnerEntity.getPartnerType().equals(PartnerTypeEnum.PESSOA_FISICA.getType())){
    		individualEntity = (IndividualEntity)partnerEntity;
    		return IndividualConverter.convert(individualEntity);
    	}
    	
    	return null;
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Company save(Company company) {
    	company.setSignupDate(new Date());
    	company.setPartnerType(PartnerTypeEnum.PESSOA_JURIDICA.getType());
        CompanyEntity companyEntity = CompanyConverter.convert(company);
        companyEntity = partnerRepository.save(companyEntity);
    	return CompanyConverter.convert(companyEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Individual save(Individual individual) {
    	individual.setSignupDate(new Date());
    	individual.setPartnerType(PartnerTypeEnum.PESSOA_FISICA.getType());
        IndividualEntity individualEntity = IndividualConverter.convert(individual);
        individualEntity = partnerRepository.save(individualEntity);
    	return IndividualConverter.convert(individualEntity);
	}
    
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Partner update(Partner partner) {
    	PartnerEntity partnerEntity = partnerRepository.findByIdPartner(partner.getIdPartner());
    	PartnerEntity partnerEntitySaved = partnerRepository.save(partnerEntity);
        return PartnerConverter.convert(partnerEntitySaved);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public void delete(Integer idPartner) {
    	PartnerEntity partnerEntity = partnerRepository.findByIdPartner(idPartner);
        partnerRepository.delete(partnerEntity.getIdPartner());        
    }
    
}

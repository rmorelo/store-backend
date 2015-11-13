package br.com.store.backend.domain.service.partner;

import java.util.Date;

import javax.annotation.Resource;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.CompanyEntity;
import br.com.store.backend.domain.entity.IndividualEntity;
import br.com.store.backend.domain.entity.PartnerEntity;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Company;
import br.com.store.backend.view.resource.partner.Individual;
import br.com.store.backend.view.resource.partner.Partner;

@Service
@Transactional(readOnly = true)
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Resource
	private PartnerServiceMapper partnerServiceMapper;
    
    @Profiled(level = Profiling.SERVICE)
    @Override
    
    public Partner findByIdPartner(Integer idPartner) {
    	PartnerEntity partnerEntity = partnerRepository.findByIdPartner(idPartner);
    	return PartnerConverter.convert(partnerEntity);
    }
    
    @Override
    @Transactional
	public Company save(Company company) {
    	company.setSignupDate(new Date());
        CompanyEntity companyEntity = CompanyConverter.convert(company);
        companyEntity = partnerRepository.save(companyEntity);
    	return CompanyConverter.convert(companyEntity);
	}
    
    @Override
    @Transactional
	public Individual save(Individual individual) {
    	individual.setSignupDate(new Date());
        IndividualEntity individualEntity = IndividualConverter.convert(individual);
        individualEntity = partnerRepository.save(individualEntity);
    	return IndividualConverter.convert(individualEntity);
	}
    
    
    @Override
    @Transactional
    public Partner update(Partner partner) {
    	PartnerEntity partnerEntity = partnerRepository.findByIdPartner(partner.getIdPartner());
    	partnerServiceMapper.mapPartnerToPartnerEntity(partner, partnerEntity);
    	PartnerEntity partnerEntitySaved = partnerRepository.save(partnerEntity);
        return partnerServiceMapper.mapPartnerEntityToPartner(partnerEntitySaved);
    }
    
    @Override
    @Transactional
    public void delete(Integer idPartner) {
        partnerRepository.delete(idPartner);        
    }
    
}

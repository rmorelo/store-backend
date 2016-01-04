package br.com.store.backend.domain.service.person;

import java.util.Date;
import javax.annotation.Resource;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.partner.PartnerEntity;
import br.com.store.backend.domain.entity.person.CompanyEntity;
import br.com.store.backend.domain.repository.partner.PartnerRepository;
import br.com.store.backend.domain.repository.person.CompanyRepository;
import br.com.store.backend.domain.service.person.CompanyConverter;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.person.Company;

@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService {

	@Autowired
    private CompanyRepository companyRepository;
    
    @Autowired
    private PartnerRepository partnerRepository;
    
    @Resource
    private CompanyServiceMapper companyServiceMapper;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Company findCompanyByPartner(Integer idPartner) {
    	PartnerEntity partnerEntity = partnerRepository.findOne(idPartner);
    	
    	if(partnerEntity == null){
    		throw new NotFoundException(NotFoundException.PARTNER_NOT_FOUND);
    	}
    	
    	CompanyEntity companyEntity = partnerEntity.getCompany();
    	
    	if(companyEntity == null){
    		throw new NotFoundException(NotFoundException.COMPANY_NOT_FOUND);
    	}
    	
    	return CompanyConverter.convert(companyEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Company findCompany(Integer idCompany) {
    	CompanyEntity companyEntity = companyRepository.findOne(idCompany);
    	
    	if(companyEntity == null){
    		throw new NotFoundException(NotFoundException.COMPANY_NOT_FOUND);
    	}
    	
    	return CompanyConverter.convert(companyEntity);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Company save(Company company) {
    	company.setSignupDate(new Date());
        CompanyEntity companyEntity = CompanyConverter.convert(company);
        companyEntity = companyRepository.save(companyEntity);
        return CompanyConverter.convert(companyEntity);
	}
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public Company update(Company company) {
    	CompanyEntity companyEntity = companyRepository.findOne(company.getIdCompany());
    	
    	if(companyEntity == null){
    		throw new NotFoundException(NotFoundException.COMPANY_NOT_FOUND);
    	}
    	
    	companyServiceMapper.mapCompanyToCompanyEntity(company, companyEntity);
    	CompanyEntity companyEntitySaved = companyRepository.save(companyEntity);
        return CompanyConverter.convert(companyEntitySaved);
    }
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
    public void delete(Integer idCompany) {
    	CompanyEntity companyEntity = companyRepository.findOne(idCompany);
    	
    	if(companyEntity == null){
    		throw new NotFoundException(NotFoundException.COMPANY_NOT_FOUND);
    	}
    	
    	companyRepository.delete(companyEntity.getIdCompany());        
    }
    
}

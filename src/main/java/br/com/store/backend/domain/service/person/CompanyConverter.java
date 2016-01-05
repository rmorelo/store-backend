package br.com.store.backend.domain.service.person;

import org.springframework.beans.BeanUtils;

import br.com.store.backend.domain.entity.person.CompanyEntity;
import br.com.store.backend.view.resource.person.Company;

public class CompanyConverter {

    private CompanyConverter() {
    }

    public static Company convert(CompanyEntity entity) {
        if (entity == null) {
        	return null;
        }
        Company company = new Company();
        BeanUtils.copyProperties(entity, company, "partner");
        
        return company;
    }
    
    public static CompanyEntity convert(Company company) {
        if (company == null) {
        	return null;
        }
        
        CompanyEntity entity = new CompanyEntity();
        BeanUtils.copyProperties(company, entity);
        
        return entity;
    }
    
}

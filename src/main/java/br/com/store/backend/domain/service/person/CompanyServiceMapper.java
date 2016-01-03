package br.com.store.backend.domain.service.person;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.store.backend.domain.AbstractServiceMapper;
import br.com.store.backend.domain.entity.person.CompanyEntity;
import br.com.store.backend.view.resource.person.Company;

@Component
public class CompanyServiceMapper extends AbstractServiceMapper {

	private ModelMapper modelMapper;
	
	public CompanyServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	}

	public Company mapCompanyEntityToCompany(CompanyEntity companyEntity) {
		if(companyEntity == null) {
			return null;
		}

		Company company = map(companyEntity, Company.class);
		return company;
	}
	
	public void mapCompanyToCompanyEntity(Company company, CompanyEntity companyEntity) {
		if(company == null) {
			return;
		}

		map(company, companyEntity);
	}
	
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}

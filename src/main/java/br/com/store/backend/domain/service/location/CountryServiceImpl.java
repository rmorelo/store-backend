package br.com.store.backend.domain.service.location;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.location.CountryEntity;
import br.com.store.backend.domain.repository.location.CountryRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.Country;

@Service
@Transactional(readOnly = true)
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Country findCountry(Integer idCountry) {
        CountryEntity countryEntity = countryRepository.findOne(idCountry);
        
        if(countryEntity == null){
            throw new NotFoundException(NotFoundException.COUNTRY_NOT_FOUND);
        }
        
        return CountryConverter.convert(countryEntity);
    }

}

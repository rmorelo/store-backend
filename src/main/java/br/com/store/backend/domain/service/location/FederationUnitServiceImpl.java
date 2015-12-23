package br.com.store.backend.domain.service.location;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.store.backend.domain.entity.location.CountryEntity;
import br.com.store.backend.domain.entity.location.FederationUnitEntity;
import br.com.store.backend.domain.repository.location.FederationUnitRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.location.Country;
import br.com.store.backend.view.resource.location.FederationUnit;

@Service
@Transactional(readOnly = true)
public class FederationUnitServiceImpl implements FederationUnitService {

    @Autowired
    private FederationUnitRepository federationUnitRepository;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public FederationUnit findFederationUnit(Integer idFederationUnit) {
        FederationUnitEntity federationUnitEntity = federationUnitRepository.findOne(idFederationUnit);
                
        if(federationUnitEntity == null){
            throw new NotFoundException(NotFoundException.FEDERATION_UNIT_NOT_FOUND);
        }
        
        return FederationUnitConverter.convert(federationUnitEntity);
    }
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public Country findCountryByFederationUnit(Integer idFederationUnit) {
        FederationUnitEntity federationUnitEntity = federationUnitRepository.findOne(idFederationUnit);
        
        if(federationUnitEntity == null){
            throw new NotFoundException(NotFoundException.FEDERATION_UNIT_NOT_FOUND);
        }
        
        CountryEntity countryEntity = federationUnitEntity.getCountry();
        
        if(countryEntity == null){
            throw new NotFoundException(NotFoundException.COUNTRY_NOT_FOUND);
        }
        
        return CountryConverter.convert(countryEntity);
    }

}

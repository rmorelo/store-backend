package br.com.store.backend.domain.service.location;

import org.springframework.beans.BeanUtils;
import br.com.store.backend.domain.entity.location.FederationUnitEntity;
import br.com.store.backend.view.resource.location.FederationUnit;

public class FederationUnitConverter {

    private FederationUnitConverter() {
    }

    public static FederationUnit convert(FederationUnitEntity federationUnitEntity) {
        if (federationUnitEntity == null) {
        	return null;
        }
        
        FederationUnit federationUnit = new FederationUnit();
        BeanUtils.copyProperties(federationUnitEntity, federationUnit);

        return federationUnit;
    }
    
    public static FederationUnitEntity convert(FederationUnit federationUnit) {
        if (federationUnit == null) {
        	return null;
        }
        FederationUnitEntity federationUnitEntity = new FederationUnitEntity();
        BeanUtils.copyProperties(federationUnit, federationUnitEntity);
        
        return federationUnitEntity;
    }
    
}

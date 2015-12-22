package br.com.store.backend.domain.service.location;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.DistrictEntity;
import br.com.store.backend.domain.repository.partner.DistrictRepository;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.District;

@Service
@Transactional(readOnly = true)
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;
    
    @Override
    @Profiled(level = Profiling.SERVICE)
    public District find(Integer idDistrict) {
        DistrictEntity districtEntity = districtRepository.findOne(idDistrict);
                
        if(districtEntity == null){
            throw new NotFoundException(NotFoundException.DISTRICT_NOT_FOUND);
        }
        
        return DistrictConverter.convert(districtEntity);
    }
    
    

}

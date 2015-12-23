package br.com.store.backend.domain.service.contact;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.ConfirmationStatusEnum;
import br.com.store.backend.domain.entity.contact.TelephoneEntity;
import br.com.store.backend.domain.repository.contact.TelephoneRepository;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.contact.Telephone;

@Service
@Transactional(readOnly = true)
public class TelephoneServiceImpl implements TelephoneService {

    @Autowired
    private TelephoneRepository telephoneRepository;
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Telephone save(Telephone telephone){
    	telephone.setConfirmation(ConfirmationStatusEnum.PENDING.getStatus());
        TelephoneEntity telephoneEntity = TelephoneConverter.convert(telephone);
        telephoneEntity = telephoneRepository.save(telephoneEntity);
        return TelephoneConverter.convert(telephoneEntity);
	}

}

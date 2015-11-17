package br.com.store.backend.domain.service.email;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.store.backend.domain.entity.ConfirmationStatusEnum;
import br.com.store.backend.domain.entity.EmailEntity;
import br.com.store.backend.domain.repository.partner.EmailRepository;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Email;

@Service
@Transactional(readOnly = true)
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;
    
    @Override
    @Transactional
    @Profiled(level = Profiling.SERVICE)
	public Email save(Email email){
    	email.setConfirmation(ConfirmationStatusEnum.INACTIVE.getStatus());
        EmailEntity emailEntity = EmailConverter.convert(email);
        emailEntity = emailRepository.save(emailEntity);
        return EmailConverter.convert(emailEntity);
	}

}

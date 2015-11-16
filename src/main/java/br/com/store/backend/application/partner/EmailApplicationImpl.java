package br.com.store.backend.application.partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.email.EmailService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.Email;

@Service
public class EmailApplicationImpl implements EmailApplication {

    @Autowired
    private EmailService emailService;
   
	
}

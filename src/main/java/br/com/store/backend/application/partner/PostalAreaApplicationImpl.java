package br.com.store.backend.application.partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.store.backend.domain.service.location.PostalAreaService;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.view.resource.partner.PostalArea;

@Service
public class PostalAreaApplicationImpl implements PostalAreaApplication {

	@Autowired
    private PostalAreaService postalAreaService;
    
    @Override
    @Profiled(level = Profiling.APPLICATION)    
	public PostalArea findByCodPostalArea(String codPostalArea){
        return postalAreaService.findByCodPostalArea(codPostalArea);
	}

}

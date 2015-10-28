package br.com.store.view.endpoint;

import br.com.store.application.partner.PartnerApplication;
import br.com.store.infrastructure.annotation.Authentication;
import br.com.store.infrastructure.profiling.Profiling;


import br.com.store.infrastructure.rest.model.Resource;
import br.com.store.view.resource.partner.Partner;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@RestController
public class PartnerEndpoint {

    private static final String PARTNER_PATH = "/partners";
    @Autowired
    private PartnerApplication partnerApplication;

    @Profiled(level = Profiling.ENDPOINT)
    @Authentication
    @RequestMapping(value = PARTNER_PATH, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<Partner>> getPartner() {
        Partner partner = partnerApplication.getPartner();
        return new ResponseEntity<>(new Resource<Partner>(partner), HttpStatus.OK);
    }

}

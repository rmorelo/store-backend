package br.com.store.backend.view.endpoint.pet;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.store.backend.application.pet.GroupApplication;
import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.backend.view.resource.pet.Group;

@RestController
public class GroupEndpoint {

    @Autowired
    private GroupApplication groupApplication;
    
    @Autowired
    private HttpServletRequest request;
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/species/{idSpecies}/groups", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Resource<Group>> findGroupBySpecies(@PathVariable(value = "idSpecies") Integer idSpecies) {
        
    	Group group = groupApplication.findGroupBySpecies(idSpecies);
    	group.setUri(request.getRequestURI(), request.getQueryString());
        
        return new ResponseEntity<>(new Resource<Group>(group), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/groups/{idGroup}", method = RequestMethod.GET)
    public ResponseEntity<Resource<Group>> findByIdGroup(
    		@PathVariable(value = "idGroup") Integer idGroup) {
    	Group group = groupApplication.findGroup(idGroup);
    	group.setUri(request.getRequestURI(), request.getQueryString());
    	
    	return new ResponseEntity<>(new Resource<Group>(group), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public ResponseEntity<Resource<Collection<Group>>> findGroups() {
    	Collection<Group> groups = groupApplication.findGroups();
    	Collection<Group> groupsResult = new ArrayList<Group>();
    	
    	for(Group group : groups){
        	group.setUri(request.getRequestURI(), request.getQueryString());
        	groupsResult.add(group);
    	}
    	
    	return new ResponseEntity<>(new Resource<Collection<Group>>(groupsResult), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    public ResponseEntity<Resource<Group>> saveGroup(@RequestBody Group group) {
    	Group groupResource = groupApplication.saveGroup(group);
    	groupResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Group>(groupResource), HttpStatus.CREATED);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/groups/{idGroup}", method = RequestMethod.PUT)
    public ResponseEntity<Resource<Group>> update(@PathVariable(value = "idGroup") Integer idGroup,
            @Validated @RequestBody Group group) {
        group.setIdGroup(idGroup);
        Group groupResource = groupApplication.update(group);
        groupResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Group>(groupResource), HttpStatus.OK);
    }
        
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/groups/{idGroup}", method = RequestMethod.PATCH)
    public ResponseEntity<Resource<Group>> updatePartial(@PathVariable(value = "idGroup") Integer idGroup,
            @Validated @RequestBody Group group) {
        group.setIdGroup(idGroup);
        Group groupResource = groupApplication.update(group);
        groupResource.setUri(request.getRequestURI(), request.getQueryString());

        return new ResponseEntity<>(new Resource<Group>(groupResource), HttpStatus.OK);
    }
    
    @Profiled(level = Profiling.ENDPOINT)
    @RequestMapping(value = "/groups/{idGroup}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Group>> delete(@PathVariable(value = "idGroup") Integer idGroup){
        groupApplication.delete(idGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }    
}
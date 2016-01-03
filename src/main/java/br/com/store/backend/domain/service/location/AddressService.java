package br.com.store.backend.domain.service.location;

import br.com.store.backend.view.resource.location.Address;
import br.com.store.backend.view.resource.location.PostalArea;

public interface AddressService {
	
    Address findAddress(Integer idAddress);
        
    PostalArea findPostalAreaByAddress(Integer idAddress);
    
    Address findAddressByPartner(Integer idPartner);
    
    Address save(Address address);
    
    Address update(Address address);
    
    void delete(Integer idAddress);
}

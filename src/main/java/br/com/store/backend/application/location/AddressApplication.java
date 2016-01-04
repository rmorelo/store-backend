package br.com.store.backend.application.location;

import br.com.store.backend.view.resource.location.Address;

public interface AddressApplication {
 
    Address findAddress(Integer idAddress, String selector);
    
    Address save(Address address);
    
    Address saveAddressOfPartner(Integer idPartner, Address address);
    
    Address update(Address address);
    
    void delete(Integer idAddress);
    
}


package com.connect.services;

import com.connect.entities.Address;
import com.connect.entities.Resident;
import com.connect.repositories.AddressRepository;
import exception.MiException;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepo;
    
    
    @Transactional
    public void createAddress(String street, String residentNumber, String housingType, String postalCode,
            Integer floor, String city, String doorNumber, Resident resident) throws MiException {
        
        
        Address address = new Address();
        
        address.setStreet(street);
        address.setResidentNumber(residentNumber);
        address.setHousingType(housingType);
        address.setPostalCode(postalCode);
        address.setFloor(floor);
        address.setCity(city);
        address.setDoorNumber(doorNumber);
        address.setResident(resident);
        
        addressRepo.save(address);
        
    }
    
    @Transactional
    public void modifyAddress(String id, String street, String residentNumber, String housingType, String postalCode,
            Integer floor, String city, String doorNumber, Resident resident) throws MiException {
        
        
        Optional<Address> response = addressRepo.findById(id);
        
        if(response.isPresent()){
            Address address = response.get();
            address.setStreet(street);
            address.setResidentNumber(residentNumber);
            address.setHousingType(housingType);
            address.setPostalCode(postalCode);
            address.setFloor(floor);
            address.setCity(city);
            address.setDoorNumber(doorNumber);
            address.setResident(resident);
            
            addressRepo.save(address);
        }
        
    }
    
    public void deleteAddress(String id){
        addressRepo.deleteById(id);
    }
    
    public Address searchAddressById(String id){
         Optional<Address> response = addressRepo.findById(id);
        
        if(response.isPresent()){
            return response.get();
        }
        return null;
    }
   
}

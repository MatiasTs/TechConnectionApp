
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
        
        validation(street, residentNumber, housingType, postalCode, floor, city, doorNumber, resident);
        
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
        
        validation(street, residentNumber, housingType, postalCode, floor, city, doorNumber, resident);
        
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
    
    public Address searchAddressById(String id){
         Optional<Address> response = addressRepo.findById(id);
        
        if(response.isPresent()){
            return response.get();
        }
        return null;
    }
    
    
    public void validation(String street, String residentNumber, String housingType, String postalCode,
            Integer floor, String city, String doorNumber, Resident resident) throws MiException{
        
        if(street.isEmpty() || street == null){
            throw new MiException("The street name cannot be empty");
        }
        
        if(residentNumber.isEmpty() || residentNumber == null){
            throw new MiException("The number of the resident cannot be null");
        }
        
        if(housingType.isEmpty() || housingType == null){
            throw new MiException("The housing type cannot be empty");
        }
        
        if(postalCode.isEmpty() || postalCode == null){
            throw new MiException("The costa code cannot be empty");
        }
        
        if(floor == null){
            throw new MiException("The floor cannot be empty");
        }
        
        if(city.isEmpty() || city == null){
            throw new MiException("The city cannot be empty");
        }
        
        if(doorNumber.isEmpty() || doorNumber == null){
            throw new MiException("The door number cannot be empty");
        }
        
        if(resident == null){
            throw new MiException("You have to indicate a resident");
        }
        
    }
}

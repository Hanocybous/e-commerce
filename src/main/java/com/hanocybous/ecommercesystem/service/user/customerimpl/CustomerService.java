package com.hanocybous.ecommercesystem.service.user.customerimpl;

import com.hanocybous.ecommercesystem.dto.user.CustomerDto;
import com.hanocybous.ecommercesystem.repository.user.CustomerRepository;
import com.hanocybous.ecommercesystem.service.user.ICustomerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Getter
@SuppressWarnings("unused")
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // get customer by address
    public List<CustomerDto> getCustomerByAddress(String address) {
        if (address == null || address.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByAddress(address);
    }

    // get customer by city
    public List<CustomerDto> getCustomerByCity(String city) {
        if (city == null || city.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByCity(city);
    }

    // get customer by country
    public List<CustomerDto> getCustomerByCountry(String country) {
        if (country == null || country.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByCountry(country);
    }

    // get customer by phone number
    public List<CustomerDto> getCustomerByPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByPhoneNumber(phoneNumber);
    }

    @Override
    public List<CustomerDto> getCustomerByAddressAndPhoneNumber(String address, String phoneNumber) {
        if (address == null || address.isEmpty() || phoneNumber == null || phoneNumber.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByAddressAndPhoneNumber(address, phoneNumber);
    }

    // get customer by state
    public List<CustomerDto> getCustomerByState(String state) {
        if (state == null || state.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByState(state);
    }

    // get customer by zip code
    public List<CustomerDto> getCustomerByZipCode(String zipCode) {
        if (zipCode == null || zipCode.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByZipCode(zipCode);
    }

    // get customer by full name and zip code
    public List<CustomerDto> getCustomerByFullNameAndZipCode(String fullName, String zipCode) {
        if (fullName == null || fullName.isEmpty() || zipCode == null || zipCode.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByFullNameAndZipCode(fullName, zipCode);
    }

    // get customer by full name and state
    public List<CustomerDto> getCustomerByFullNameAndState(String fullName, String state) {
        if (fullName == null || fullName.isEmpty() || state == null || state.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByFullNameAndState(fullName, state);
    }

    // get customer by full name and phone number
    public List<CustomerDto> getCustomerByFullNameAndPhoneNumber(String fullName, String phoneNumber) {
        if (fullName == null || fullName.isEmpty() || phoneNumber == null || phoneNumber.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByFullNameAndPhoneNumber(fullName, phoneNumber);
    }

    public List<CustomerDto> getCustomerByFullNameAndCountry(String fullName, String country) {
        if (fullName == null || fullName.isEmpty() || country == null || country.isEmpty()) {
            return Collections.emptyList();
        }
        return customerRepository.getCustomerByFullNameAndCountry(fullName, country);
    }

    // delete customer by full name and zip code
    public void deleteCustomerByFullNameAndZipCode(String fullName, String zipCode) {
        if (fullName == null || fullName.isEmpty() || zipCode == null || zipCode.isEmpty()) {
            return;
        }
        customerRepository.deleteCustomerByFullNameAndZipCode(fullName, zipCode);
    }

    // delete customer by full name and state
    public void deleteCustomerByFullNameAndState(String fullName, String state) {
        if (fullName == null || fullName.isEmpty() || state == null || state.isEmpty()) {
            return;
        }
        customerRepository.deleteCustomerByFullNameAndState(fullName, state);
    }

    // delete customer by full name and phone number
    public void deleteCustomerByFullNameAndPhoneNumber(String fullName, String phoneNumber) {
        if (fullName == null || fullName.isEmpty() || phoneNumber == null || phoneNumber.isEmpty()) {
            return;
        }
        customerRepository.deleteCustomerByFullNameAndPhoneNumber(fullName, phoneNumber);
    }

    // delete customer by full name and country
    public void deleteCustomerByFullNameAndCountry(String fullName, String country) {
        if (fullName == null || fullName.isEmpty() || country == null || country.isEmpty()) {
            return;
        }
        customerRepository.deleteCustomerByFullNameAndCountry(fullName, country);
    }

    // delete customer by address
    public void deleteCustomerByAddress(String address) {
        if (address == null || address.isEmpty()) {
            return;
        }
        customerRepository.deleteCustomerByAddress(address);
    }

    // delete customer by city
    public void deleteCustomerByCity(String city) {
        if (city == null || city.isEmpty()) {
            return;
        }
        customerRepository.deleteCustomerByCity(city);
    }

    // delete customer by country
    public void deleteCustomerByCountry(String country) {
        if (country == null || country.isEmpty()) {
            return;
        }
        customerRepository.deleteCustomerByCountry(country);
    }

    // delete customer by phone number
    public void deleteCustomerByPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return;
        }
        customerRepository.deleteCustomerByPhoneNumber(phoneNumber);
    }

    // delete customer by state
    public void deleteCustomerByState(String state) {
        if (state == null || state.isEmpty()) {
            return;
        }
        customerRepository.deleteCustomerByState(state);
    }

    // delete customer by zip code
    public void deleteCustomerByZipCode(String zipCode) {
        if (zipCode == null || zipCode.isEmpty()) {
            return;
        }
        customerRepository.deleteCustomerByZipCode(zipCode);
    }

    // update customer by id
    public void updateCustomerById(String fullName,
                                   String address,
                                   String city,
                                   String country,
                                   String phoneNumber,
                                   String state,
                                   String zipCode,
                                   Long id) {
        if (fullName == null ||
                fullName.isEmpty() ||
                address == null ||
                address.isEmpty() ||
                city == null ||
                city.isEmpty() ||
                country == null ||
                country.isEmpty() ||
                phoneNumber == null ||
                phoneNumber.isEmpty() ||
                state == null ||
                state.isEmpty() ||
                zipCode == null ||
                zipCode.isEmpty() ||
                id == null) {
            return;
        }
        customerRepository.updateCustomerById(fullName,
                address,
                city,
                country,
                phoneNumber,
                state,
                zipCode,
                id);
    }

    // update customer full name by id
    public void updateCustomerFullName(String fullName, Long id) {
        if (fullName == null ||
                fullName.isEmpty() ||
                id == null) {
            return;
        }
        customerRepository.updateCustomerFullName(fullName, id);
    }

    // update customer address by id
    public void updateCustomerAddress(String address, Long id) {
        if (address == null ||
                address.isEmpty() ||
                id == null) {
            return;
        }
        customerRepository.updateCustomerAddress(address, id);
    }

    // update customer city by id
    public void updateCustomerCity(String city, Long id) {
        if (city == null ||
                city.isEmpty() ||
                id == null) {
            return;
        }
        customerRepository.updateCustomerCity(city, id);
    }

    // update customer country by id
    public void updateCustomerCountry(String country, Long id) {
        if (country == null ||
                country.isEmpty() ||
                id == null) {
            return;
        }
        customerRepository.updateCustomerCountry(country, id);
    }

    // update customer phone number by id
    public void updateCustomerPhoneNumber(String phoneNumber, Long id) {
        if (phoneNumber == null ||
                phoneNumber.isEmpty() ||
                id == null) {
            return;
        }
        customerRepository.updateCustomerPhoneNumber(phoneNumber, id);
    }

    // update customer state by id
    public void updateCustomerState(String state, Long id) {
        if (state == null ||
                state.isEmpty() ||
                id == null) {
            return;
        }
        customerRepository.updateCustomerState(state, id);
    }

    // update customer zip code by id
    public void updateCustomerZipCode(String zipCode, Long id) {
        if (zipCode == null ||
                zipCode.isEmpty() ||
                id == null) {
            return;
        }
        customerRepository.updateCustomerZipCode(zipCode, id);
    }

    // delete customer by id
    public void deleteCustomerById(Long id) {
        if (id == null) {
            return;
        }
        customerRepository.deleteCustomerById(id);
    }

    public void updateCustomerFullNameAndZipCode(String fullName, String zipCode, Long id) {
        if (fullName == null ||
                fullName.isEmpty() ||
                zipCode == null ||
                zipCode.isEmpty() ||
                id == null) {
            return;
        }
        customerRepository.updateCustomerFullNameAndZipCode(fullName, zipCode, id);
    }

}

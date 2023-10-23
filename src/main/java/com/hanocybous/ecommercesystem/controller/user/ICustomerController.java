package com.hanocybous.ecommercesystem.controller.user;

import com.hanocybous.ecommercesystem.dto.user.CustomerDto;

import java.util.List;

public interface ICustomerController {

    List<CustomerDto> getCustomerByAddress(String address);

    List<CustomerDto> getCustomerByPhoneNumber(String phoneNumber);

    List<CustomerDto> getCustomerByCity(String city);

    List<CustomerDto> getCustomerByCountry(String country);

    List<CustomerDto> getCustomerByState(String state);

    List<CustomerDto> getCustomerByZipCode(String zipCode);

    void deleteCustomerByAddress(String address);

    void deleteCustomerByPhoneNumber(String phoneNumber);

    void deleteCustomerByCity(String city);

    void deleteCustomerByCountry(String country);

    void deleteCustomerByState(String state);

    void deleteCustomerByZipCode(String zipCode);

    void deleteCustomerById(Long id);

    void updateCustomerById(Long id, CustomerDto customerDto);

}

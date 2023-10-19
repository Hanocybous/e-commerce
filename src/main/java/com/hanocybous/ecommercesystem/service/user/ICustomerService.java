package com.hanocybous.ecommercesystem.service.user;

import com.hanocybous.ecommercesystem.dto.user.CustomerDto;

import java.util.List;

public interface ICustomerService {

    List<CustomerDto> getCustomerByAddress(String address);

    List<CustomerDto> getCustomerByPhoneNumber(String phoneNumber);

    List<CustomerDto> getCustomerByAddressAndPhoneNumber(String address, String phoneNumber);

    List<CustomerDto> getCustomerByZipCode(String zipCode);

    List<CustomerDto> getCustomerByState(String state);

}

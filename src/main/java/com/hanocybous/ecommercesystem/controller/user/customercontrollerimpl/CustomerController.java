package com.hanocybous.ecommercesystem.controller.user.customercontrollerimpl;

import com.hanocybous.ecommercesystem.controller.user.ICustomerController;
import com.hanocybous.ecommercesystem.dto.user.CustomerDto;
import com.hanocybous.ecommercesystem.service.user.customerimpl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/customer")
public class CustomerController implements ICustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustomerByAddress/{address}")
    @ResponseBody
    public List<CustomerDto> getCustomerByAddress(
            @RequestBody
            @PathVariable String address) {
        return customerService.getCustomerByAddress(address);
    }

    @GetMapping("/getCustomerByPhoneNumber/{phoneNumber}")
    @ResponseBody
    public List<CustomerDto> getCustomerByPhoneNumber(
            @RequestBody
            @PathVariable String phoneNumber) {
        return customerService.getCustomerByPhoneNumber(phoneNumber);
    }

    @GetMapping("/getCustomerByCity/{city}")
    @ResponseBody
    public List<CustomerDto> getCustomerByCity(
            @RequestBody
            @PathVariable String city) {
        return customerService.getCustomerByCity(city);
    }

    @GetMapping("/getCustomerByCountry/{country}")
    @ResponseBody
    public List<CustomerDto> getCustomerByCountry(
            @RequestBody
            @PathVariable String country) {
        return customerService.getCustomerByCountry(country);
    }

    @GetMapping("/getCustomerByState/{state}")
    @ResponseBody
    public List<CustomerDto> getCustomerByState(
            @RequestBody
            @PathVariable String state) {
        return customerService.getCustomerByState(state);
    }

    @GetMapping("/getCustomerByZipCode/{zipCode}")
    @ResponseBody
    public List<CustomerDto> getCustomerByZipCode(
            @RequestBody
            @PathVariable String zipCode) {
        return customerService.getCustomerByZipCode(zipCode);
    }

    @GetMapping("/getCustomerByAddressAndPhoneNumber/{address}/{phoneNumber}")
    @ResponseBody
    public List<CustomerDto> getCustomerByAddressAndPhoneNumber(
            @RequestBody
            @PathVariable String address,
            @PathVariable String phoneNumber) {
        return customerService.getCustomerByAddressAndPhoneNumber(address, phoneNumber);
    }

    @GetMapping("/getCustomerByFullNameAndZipCode/{fullName}/{zipCode}")
    @ResponseBody
    public List<CustomerDto> getCustomerByFullNameAndZipCode(
            @RequestBody
            @PathVariable String fullName,
            @PathVariable String zipCode) {
        return customerService.getCustomerByFullNameAndZipCode(fullName, zipCode);
    }

    @GetMapping("/getCustomerByFullNameAndPhoneNumber/{fullName}/{phoneNumber}")
    @ResponseBody
    public List<CustomerDto> getCustomerByFullNameAndPhoneNumber(
            @RequestBody
            @PathVariable String fullName,
            @PathVariable String phoneNumber) {
        return customerService.getCustomerByFullNameAndPhoneNumber(fullName, phoneNumber);
    }

    @GetMapping("/getCustomerByFullNameAndAddress/{fullName}/{state}")
    @ResponseBody
    public List<CustomerDto> getCustomerByFullNameAndState(
            @RequestBody
            @PathVariable String fullName,
            @PathVariable String state) {
        return customerService.getCustomerByFullNameAndState(fullName, state);
    }

    @GetMapping("/getCustomerByFullNameAndCity/{fullName}/{country}")
    @ResponseBody
    public List<CustomerDto> getCustomerByFullNameAndCountry(
            @RequestBody
            @PathVariable String fullName,
            @PathVariable String country) {
        return customerService.getCustomerByFullNameAndCountry(fullName, country);
    }

    @DeleteMapping("/deleteCustomerByFullNameAndZipCode/{fullName}/{zipCode}")
    @ResponseBody
    public void deleteCustomerByFullNameAndZipCode(
            @RequestBody
            @PathVariable String fullName,
            @PathVariable String zipCode) {
        customerService.deleteCustomerByFullNameAndZipCode(fullName, zipCode);
    }

    @DeleteMapping("/deleteCustomerByFullNameAndState/{fullName}/{state}")
    @ResponseBody
    public void deleteCustomerByFullNameAndState(
            @RequestBody
            @PathVariable String fullName,
            @PathVariable String state) {
        customerService.deleteCustomerByFullNameAndState(fullName, state);
    }

    @DeleteMapping("/deleteCustomerByFullNameAndPhoneNumber/{fullName}/{phoneNumber}")
    @ResponseBody
    public void deleteCustomerByFullNameAndPhoneNumber(
            @RequestBody
            @PathVariable String fullName,
            @PathVariable String phoneNumber) {
        customerService.deleteCustomerByFullNameAndPhoneNumber(fullName, phoneNumber);
    }

    @DeleteMapping("/deleteCustomerByFullNameAndCountry/{fullName}/{country}")
    @ResponseBody
    public void deleteCustomerByFullNameAndCountry(
            @RequestBody
            @PathVariable String fullName,
            @PathVariable String country) {
        customerService.deleteCustomerByFullNameAndCountry(fullName, country);
    }

    @DeleteMapping("/deleteCustomerByFullNameAndCity/{address}")
    @ResponseBody
    public void deleteCustomerByAddress(
            @RequestBody
            @PathVariable String address) {
        customerService.deleteCustomerByAddress(address);
    }

    @DeleteMapping("/deleteCustomerByCity/{city}")
    @ResponseBody
    public void deleteCustomerByCity(
            @RequestBody
            @PathVariable String city) {
        customerService.deleteCustomerByCity(city);
    }

    @DeleteMapping("/deleteCustomerByCountry/{country}")
    @ResponseBody
    public void deleteCustomerByCountry(
            @RequestBody
            @PathVariable String country) {
        customerService.deleteCustomerByCountry(country);
    }

    @DeleteMapping("/deleteCustomerByState/{state}")
    @ResponseBody
    public void deleteCustomerByState(
            @RequestBody
            @PathVariable String state) {
        customerService.deleteCustomerByState(state);
    }

    @DeleteMapping("/deleteCustomerByZipCode/{zipCode}")
    @ResponseBody
    public void deleteCustomerByZipCode(
            @RequestBody
            @PathVariable String zipCode) {
        customerService.deleteCustomerByZipCode(zipCode);
    }

    @DeleteMapping("/deleteCustomerByPhoneNumber/{phoneNumber}")
    @ResponseBody
    public void deleteCustomerByPhoneNumber(
            @RequestBody
            @PathVariable String phoneNumber) {
        customerService.deleteCustomerByPhoneNumber(phoneNumber);
    }

    @PostMapping("/updateCustomerById/{id}")
    @ResponseBody
        public void updateCustomerById(
            @RequestBody
            @PathVariable Long id,
            @RequestBody
            @RequestParam(required = false) String fullName,
            @RequestBody
            @RequestParam(required = false) String address,
            @RequestBody
            @RequestParam(required = false) String city,
            @RequestBody
            @RequestParam(required = false) String state,
            @RequestBody
            @RequestParam(required = false) String country,
            @RequestBody
            @RequestParam(required = false) String zipCode,
            @RequestBody
            @RequestParam(required = false) String phoneNumber) {
        customerService.updateCustomerById(fullName, address, city, country, phoneNumber, state, zipCode, id);
    }

    @PostMapping("/updateCustomerByFullName/{fullName}")
    @ResponseBody
    public void updateCustomerFullName(
            @RequestBody
            @PathVariable String fullName,
            @RequestBody
            @RequestParam(required = false) Long id) {
        customerService.updateCustomerFullName(fullName, id);
    }

    @PostMapping("/updateCustomerByAddress/{address}")
    @ResponseBody
    public void updateCustomerAddress(
            @RequestBody
            @PathVariable String address,
            @RequestBody
            @RequestParam(required = false) Long id) {
        customerService.updateCustomerAddress(address, id);
    }

    @PostMapping("/updateCustomerByCity/{city}")
    @ResponseBody
    public void updateCustomerCity(
            @RequestBody
            @PathVariable String city,
            @RequestBody
            @RequestParam(required = false) Long id) {
        customerService.updateCustomerCity(city, id);
    }

    @PostMapping("/updateCustomerByState/{state}")
    @ResponseBody
    public void updateCustomerState(
            @RequestBody
            @PathVariable String state,
            @RequestBody
            @RequestParam(required = false) Long id) {
        customerService.updateCustomerState(state, id);
    }

    @PostMapping("/updateCustomerByCountry/{country}")
    @ResponseBody
    public void updateCustomerCountry(
            @RequestBody
            @PathVariable String country,
            @RequestBody
            @RequestParam(required = false) Long id) {
        customerService.updateCustomerCountry(country, id);
    }

    @PostMapping("/updateCustomerByZipCode/{zipCode}")
    @ResponseBody
    public void updateCustomerZipCode(
            @RequestBody
            @PathVariable String zipCode,
            @RequestBody
            @RequestParam(required = false) Long id) {
        customerService.updateCustomerZipCode(zipCode, id);
    }

    @PostMapping("/updateCustomerByPhoneNumber/{phoneNumber}")
    @ResponseBody
    public void updateCustomerPhoneNumber(
            @RequestBody
            @PathVariable String phoneNumber,
            @RequestBody
            @RequestParam(required = false) Long id) {
        customerService.updateCustomerPhoneNumber(phoneNumber, id);
    }

    @DeleteMapping("/deleteCustomerById/{id}")
    @ResponseBody
    public void deleteCustomerById(
            @RequestBody
            @PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }

    @Override
    public void updateCustomerById(
            Long id,
            CustomerDto customerDto) {
        customerService.updateCustomerById(id, customerDto);
    }

    @PostMapping("/updateCustomerFullNameAndZipCode/{fullName}/{zipCode}")
    @ResponseBody
    public void updateCustomerFullNameAndZipCode(
            @RequestBody
            @PathVariable String fullName,
            @RequestBody
            @PathVariable String zipCode,
            @RequestBody
            @RequestParam(required = false) Long id) {
        customerService.updateCustomerFullNameAndZipCode(fullName, zipCode, id);
    }

}

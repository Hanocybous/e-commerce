package com.hanocybous.ecommercesystem.service.user;

import com.hanocybous.ecommercesystem.dto.user.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> getCustomerByEmail(String email);

    List<UserDto> getSellerByEmail(String email);

    List<UserDto> getAdminByEmail(String email);

    List<UserDto> getCustomerByUsername(String username);

    List<UserDto> getSellerByUsername(String username);

    List<UserDto> getAdminByUsername(String username);

    List<UserDto> getSellerById(Long id);

    List<UserDto> getCustomerById(Long id);

    List<UserDto> getAdminById(Long id);

    List<UserDto> getAdminByFullName(String fullName);

    List<UserDto> getCustomerByFullName(String fullName);

    List<UserDto> getSellerByFullName(String fullName);

}

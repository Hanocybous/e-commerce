package com.hanocybous.ecommercesystem.controller.user;

import com.hanocybous.ecommercesystem.dto.user.UserDto;

import java.util.List;

public interface IUserController {

    List<UserDto> getCustomerByEmail(String email);

    List<UserDto> getSellerByEmail(String email);

    List<UserDto> getAdminByEmail(String email);

    List<UserDto> getCustomerByUsername(String username);

    List<UserDto> getSellerByUsername(String username);

    List<UserDto> getAdminByUsername(String username);

    List<UserDto> getAllUsers();

    List<UserDto> getAllCustomers();

    List<UserDto> getAllSellers();

    List<UserDto> getAllAdmins();

    List<UserDto> getSellerById(Long id);

    List<UserDto> getCustomerById(Long id);

    List<UserDto> getAdminById(Long id);

    List<UserDto> getAdminByFullName(String fullName);

    List<UserDto> getCustomerByFullName(String fullName);

    List<UserDto> getSellerByFullName(String fullName);

    List<UserDto> getAllUsersByFullName(String fullName);

    List<UserDto> getAllUsersByUsername(String username);

    List<UserDto> getAllUsersByEmail(String email);

    List<UserDto> getAllUsersById(Long id);

}

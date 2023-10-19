package com.hanocybous.ecommercesystem.service.user;

import com.hanocybous.ecommercesystem.dto.user.UserDto;
import com.hanocybous.ecommercesystem.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get customer by email
    public List<UserDto> getCustomerByEmail(String email) {
        if (email == null) {
            return Collections.emptyList();
        }
        return userRepository.getCustomerByEmail(email);
    }

    // get seller by email
    public List<UserDto> getSellerByEmail(String email) {
        if (email == null) {
            return Collections.emptyList();
        }
        return userRepository.getSellerByEmail(email);
    }

    // get admin by email
    public List<UserDto> getAdminByEmail(String email) {
        if (email == null) {
            return Collections.emptyList();
        }
        return userRepository.getAdminByEmail(email);
    }

    // get customer by username
    public List<UserDto> getCustomerByUsername(String username) {
        if (username == null) {
            return Collections.emptyList();
        }
        return userRepository.getCustomerByUsername(username);
    }

    // get seller by username
    public List<UserDto> getSellerByUsername(String username) {
        if (username == null) {
            return Collections.emptyList();
        }
        return userRepository.getSellerByUsername(username);
    }

    // get admin by username
    public List<UserDto> getAdminByUsername(String username) {
        if (username == null) {
            return Collections.emptyList();
        }
        return userRepository.getAdminByUsername(username);
    }

    // get seller by id
    public List<UserDto> getSellerById(Long id) {
        if (id == null) {
            return Collections.emptyList();
        }
        return userRepository.getSellerById(id);
    }

    // get customer by id
    public List<UserDto> getCustomerById(Long id) {
        if (id == null) {
            return Collections.emptyList();
        }
        return userRepository.getCustomerById(id);
    }

    // get admin by id
    public List<UserDto> getAdminById(Long id) {
        if (id == null) {
            return Collections.emptyList();
        }
        return userRepository.getAdminById(id);
    }

    // get all customers
    public List<UserDto> getAllCustomers() {
        return userRepository.getAllCustomers();
    }

    // get all sellers
    public List<UserDto> getAllSellers() {
        return userRepository.getAllSellers();
    }

    // get all admins
    public List<UserDto> getAllAdmins() {
        return userRepository.getAllAdmins();
    }

    // get all users
    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
    }

     // get admin by full name
    public List<UserDto> getAdminByFullName(String fullName) {
        if (fullName == null) {
            return Collections.emptyList();
        }
        return userRepository.getAdminByFullName(fullName);
    }

    // get seller by full name
    public List<UserDto> getSellerByFullName(String fullName) {
        if (fullName == null) {
            return Collections.emptyList();
        }
        return userRepository.getSellerByFullName(fullName);
    }

    // get customer by full name
    public List<UserDto> getCustomerByFullName(String fullName) {
        if (fullName == null) {
            return Collections.emptyList();
        }
        return userRepository.getCustomerByFullName(fullName);
    }

    // get all users by full name
    public List<UserDto> getAllUsersByFullName(String fullName) {
        if (fullName == null) {
            return Collections.emptyList();
        }
        return userRepository.getAllUsersByFullName(fullName);
    }

    // get all users by email
    public List<UserDto> getAllUsersByEmail(String email) {
        if (email == null) {
            return Collections.emptyList();
        }
        return userRepository.getAllUsersByEmail(email);
    }

    // get all users by username
    public List<UserDto> getAllUsersByUsername(String username) {
        if (username == null) {
            return Collections.emptyList();
        }
        return userRepository.getAllUsersByUsername(username);
    }

    // get all users by id
    public List<UserDto> getAllUsersById(Long id) {
        if (id == null) {
            return Collections.emptyList();
        }
        return userRepository.getAllUsersById(id);
    }

}

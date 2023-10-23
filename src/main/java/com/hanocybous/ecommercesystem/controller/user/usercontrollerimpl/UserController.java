package com.hanocybous.ecommercesystem.controller.user.usercontrollerimpl;

import com.hanocybous.ecommercesystem.controller.user.IUserController;
import com.hanocybous.ecommercesystem.dto.user.UserDto;
import com.hanocybous.ecommercesystem.service.user.userimpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/user")
public class UserController implements IUserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getCustomerByEmail/{email}")
    @ResponseBody
    public List<UserDto> getCustomerByEmail(
            @RequestBody
            @PathVariable String email) {
        return userService.getCustomerByEmail(email);
    }

    @GetMapping("/getSellerByEmail/{email}")
    @ResponseBody
    public List<UserDto> getSellerByEmail(
            @RequestBody
            @PathVariable String email) {
        return userService.getSellerByEmail(email);
    }

    @GetMapping("/getAdminByEmail/{email}")
    @ResponseBody
    public List<UserDto> getAdminByEmail(
            @RequestBody
            @PathVariable String email) {
        return userService.getAdminByEmail(email);
    }

    @GetMapping("/getCustomerByUsername/{username}")
    @ResponseBody
    public List<UserDto> getCustomerByUsername(
            @RequestBody
            @PathVariable String username) {
        return userService.getCustomerByUsername(username);
    }

    @GetMapping("/getSellerByUsername/{username}")
    @ResponseBody
    public List<UserDto> getSellerByUsername(
            @RequestBody
            @PathVariable String username) {
        return userService.getSellerByUsername(username);
    }

    @GetMapping("/getAdminByUsername/{username}")
    @ResponseBody
    public List<UserDto> getAdminByUsername(
            @RequestBody
            @PathVariable String username) {
        return userService.getAdminByUsername(username);
    }

    @GetMapping("/getAllCustomers")
    @ResponseBody
    public List<UserDto> getAllCustomers() {
        return userService.getAllCustomers();
    }

    @GetMapping("/getAllSellers")
    @ResponseBody
    public List<UserDto> getAllSellers() {
        return userService.getAllSellers();
    }

    @GetMapping("/getAllAdmins")
    @ResponseBody
    public List<UserDto> getAllAdmins() {
        return userService.getAllAdmins();
    }

    @GetMapping("/getSellerById/{id}")
    @ResponseBody
    public List<UserDto> getSellerById(
            @RequestBody
            @PathVariable Long id) {
        return userService.getSellerById(id);
    }

    @GetMapping("/getCustomerById/{id}")
    @ResponseBody
    public List<UserDto> getCustomerById(
            @RequestBody
            @PathVariable Long id) {
        return userService.getCustomerById(id);
    }

    @GetMapping("/getAdminById/{id}")
    @ResponseBody
    public List<UserDto> getAdminById(
            @RequestBody
            @PathVariable Long id) {
        return userService.getAdminById(id);
    }

    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getAdminByFullName/{fullName}")
    @ResponseBody
    public List<UserDto> getAdminByFullName(
            @RequestBody
            @PathVariable String fullName) {
        return userService.getAdminByFullName(fullName);
    }

    @GetMapping("/getSellerByFullName/{fullName}")
    @ResponseBody
    public List<UserDto> getSellerByFullName(
            @RequestBody
            @PathVariable String fullName) {
        return userService.getSellerByFullName(fullName);
    }

    @GetMapping("/getCustomerByFullName/{fullName}")
    @ResponseBody
    public List<UserDto> getCustomerByFullName(
            @RequestBody
            @PathVariable String fullName) {
        return userService.getCustomerByFullName(fullName);
    }

    @GetMapping("/getAllUsersByFullName/{fullName}")
    @ResponseBody
    public List<UserDto> getAllUsersByFullName(
            @RequestBody
            @PathVariable String fullName) {
        return userService.getAllUsersByFullName(fullName);
    }

    @GetMapping("/getAllUsersByUsername/{username}")
    @ResponseBody
    public List<UserDto> getAllUsersByUsername(
            @RequestBody
            @PathVariable String username) {
        return userService.getAllUsersByUsername(username);
    }

    @GetMapping("/getAllUsersByEmail/{email}")
    @ResponseBody
    public List<UserDto> getAllUsersByEmail(
            @RequestBody
            @PathVariable String email) {
        return userService.getAllUsersByEmail(email);
    }

    @GetMapping("/getAllUsersById/{id}")
    @ResponseBody
    public List<UserDto> getAllUsersById(
            @RequestBody
            @PathVariable Long id) {
        return userService.getAllUsersById(id);
    }

}

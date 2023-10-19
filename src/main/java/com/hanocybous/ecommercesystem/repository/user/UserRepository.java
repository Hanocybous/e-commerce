package com.hanocybous.ecommercesystem.repository.user;

import com.hanocybous.ecommercesystem.dto.user.UserDto;
import com.hanocybous.ecommercesystem.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE email = ?1 " +
            "AND user_type = 'CUSTOMER'" , nativeQuery = true)
    List<UserDto> getCustomerByEmail(String email);

    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE email = ?1 " +
            "AND user_type = 'SELLER'" , nativeQuery = true)
    List<UserDto> getSellerByEmail(String email);

    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE email = ?1 " +
            "AND user_type = 'ADMIN'" , nativeQuery = true)
    List<UserDto> getAdminByEmail(String email);

    // get customer by username
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE username = ?1 " +
            "AND user_type = 'CUSTOMER'" , nativeQuery = true)
    List<UserDto> getCustomerByUsername(String username);

    // get seller by username
    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE username = ?1 " +
            "AND user_type = 'SELLER'" , nativeQuery = true)
    List<UserDto> getSellerByUsername(String username);

    // get admin by username
    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE username = ?1 " +
            "AND user_type = 'ADMIN'" , nativeQuery = true)
    List<UserDto> getAdminByUsername(String username);

    // get seller by id
    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE id = ?1 " +
            "AND user_type = 'SELLER'" , nativeQuery = true)
    List<UserDto> getSellerById(Long id);

    // get customer by id
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE id = ?1 " +
            "AND user_type = 'CUSTOMER'" , nativeQuery = true)
    List<UserDto> getCustomerById(Long id);

    // get admin by id
    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE id = ?1 " +
            "AND user_type = 'ADMIN'" , nativeQuery = true)
    List<UserDto> getAdminById(Long id);

    // get admin by full name
    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE full_name = ?1 " +
            "AND user_type = 'ADMIN'" , nativeQuery = true)
    List<UserDto> getAdminByFullName(String fullName);

    // get seller by full name
    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE full_name = ?1 " +
            "AND user_type = 'SELLER'" , nativeQuery = true)
    List<UserDto> getSellerByFullName(String fullName);

    // get customer by full name
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE full_name = ?1 " +
            "AND user_type = 'CUSTOMER'" , nativeQuery = true)
    List<UserDto> getCustomerByFullName(String fullName);

    // get all admins
    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE user_type = 'ADMIN'" , nativeQuery = true)
    List<UserDto> getAllAdmins();

    // get all sellers
    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE user_type = 'SELLER'" , nativeQuery = true)
    List<UserDto> getAllSellers();

    // get all customers
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE user_type = 'CUSTOMER'" , nativeQuery = true)
    List<UserDto> getAllCustomers();

    // get all users by using the union operator to combine the results of the three queries above
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE user_type = 'CUSTOMER'" +
            "UNION " +
            "SELECT * " +
            "FROM seller " +
            "WHERE user_type = 'SELLER'" +
            "UNION " +
            "SELECT * " +
            "FROM admin " +
            "WHERE user_type = 'ADMIN'" , nativeQuery = true)
    List<UserDto> getAllUsers();

    // get all users by full name
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE full_name = ?1 " +
            "AND user_type = 'CUSTOMER'" +
            "UNION " +
            "SELECT * " +
            "FROM seller " +
            "WHERE full_name = ?1 " +
            "AND user_type = 'SELLER'" +
            "UNION " +
            "SELECT * " +
            "FROM admin " +
            "WHERE full_name = ?1 " +
            "AND user_type = 'ADMIN'" , nativeQuery = true)
    List<UserDto> getAllUsersByFullName(String fullName);

    // get all users by email
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE email = ?1 " +
            "AND user_type = 'CUSTOMER'" +
            "UNION " +
            "SELECT * " +
            "FROM seller " +
            "WHERE email = ?1 " +
            "AND user_type = 'SELLER'" +
            "UNION " +
            "SELECT * " +
            "FROM admin " +
            "WHERE email = ?1 " +
            "AND user_type = 'ADMIN'" , nativeQuery = true)
    List<UserDto> getAllUsersByEmail(String email);

    // get all users by username
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE username = ?1 " +
            "AND user_type = 'CUSTOMER'" +
            "UNION " +
            "SELECT * " +
            "FROM seller " +
            "WHERE username = ?1 " +
            "AND user_type = 'SELLER'" +
            "UNION " +
            "SELECT * " +
            "FROM admin " +
            "WHERE username = ?1 " +
            "AND user_type = 'ADMIN'" , nativeQuery = true)
    List<UserDto> getAllUsersByUsername(String username);

    // get all users by id
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE id = ?1 " +
            "AND user_type = 'CUSTOMER'" +
            "UNION " +
            "SELECT * " +
            "FROM seller " +
            "WHERE id = ?1 " +
            "AND user_type = 'SELLER'" +
            "UNION " +
            "SELECT * " +
            "FROM admin " +
            "WHERE id = ?1 " +
            "AND user_type = 'ADMIN'" , nativeQuery = true)
    List<UserDto> getAllUsersById(Long id);

}

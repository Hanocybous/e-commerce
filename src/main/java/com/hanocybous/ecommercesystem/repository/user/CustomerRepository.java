package com.hanocybous.ecommercesystem.repository.user;

import com.hanocybous.ecommercesystem.dto.user.CustomerDto;
import com.hanocybous.ecommercesystem.entity.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // get customer by address
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE address = ?1", nativeQuery = true)
    List<CustomerDto> getCustomerByAddress(String address);

    // get customer by city
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE city = ?1", nativeQuery = true)
    List<CustomerDto> getCustomerByCity(String city);

    // get customer by country
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE country = ?1", nativeQuery = true)
    List<CustomerDto> getCustomerByCountry(String country);

    // get customer by phone number
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE phone_number = ?1", nativeQuery = true)
    List<CustomerDto> getCustomerByPhoneNumber(String phoneNumber);

    // get customer by state
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE state = ?1", nativeQuery = true)
    List<CustomerDto> getCustomerByState(String state);

    // get customer by zip code
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE zip_code = ?1", nativeQuery = true)
    List<CustomerDto> getCustomerByZipCode(String zipCode);

    // get customer by full name and zip code
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE full_name = ?1 " +
            "AND zip_code = ?2", nativeQuery = true)
    List<CustomerDto> getCustomerByFullNameAndZipCode(String fullName, String zipCode);

    // get customer by full name and state
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE full_name = ?1 " +
            "AND state = ?2", nativeQuery = true)
    List<CustomerDto> getCustomerByFullNameAndState(String fullName, String state);

    // get customer by full name and phone number
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE full_name = ?1 " +
            "AND phone_number = ?2", nativeQuery = true)
    List<CustomerDto> getCustomerByFullNameAndPhoneNumber(String fullName, String phoneNumber);

    // get customer by full name and country
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE full_name = ?1 " +
            "AND country = ?2", nativeQuery = true)
    List<CustomerDto> getCustomerByFullNameAndCountry(String fullName, String country);

    // delete customer by full name and zip code
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE full_name = ?1 " +
            "AND zip_code = ?2", nativeQuery = true)
    void deleteCustomerByFullNameAndZipCode(String fullName, String zipCode);

    // delete customer by full name and state
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE full_name = ?1 " +
            "AND state = ?2", nativeQuery = true)
    void deleteCustomerByFullNameAndState(String fullName, String state);

    // delete customer by full name and phone number
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE full_name = ?1 " +
            "AND phone_number = ?2", nativeQuery = true)
    void deleteCustomerByFullNameAndPhoneNumber(String fullName, String phoneNumber);

    // delete customer by id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE id = ?1", nativeQuery = true)
    void deleteCustomerById(Long id);

    // delete customer by full name and country
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE full_name = ?1 " +
            "AND country = ?2", nativeQuery = true)
    void deleteCustomerByFullNameAndCountry(String fullName, String country);

    // delete customer by address
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE address = ?1", nativeQuery = true)
    void deleteCustomerByAddress(String address);

    // delete customer by city
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE city = ?1", nativeQuery = true)
    void deleteCustomerByCity(String city);

    // delete customer by country
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE country = ?1", nativeQuery = true)
    void deleteCustomerByCountry(String country);

    // delete customer by phone number
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE phone_number = ?1", nativeQuery = true)
    void deleteCustomerByPhoneNumber(String phoneNumber);

    // delete customer by state
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE state = ?1", nativeQuery = true)
    void deleteCustomerByState(String state);

    // delete customer by zip code
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM customer " +
            "WHERE zip_code = ?1", nativeQuery = true)
    void deleteCustomerByZipCode(String zipCode);

    // update customer by id
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET full_name = ?1, " +
            "address = ?2, " +
            "city = ?3, " +
            "state = ?4, " +
            "zip_code = ?5, " +
            "country = ?6, " +
            "phone_number = ?7 " +
            "WHERE id = ?8", nativeQuery = true)
    void updateCustomerById(String fullName,
                            String address,
                            String city,
                            String state,
                            String zipCode,
                            String country,
                            String phoneNumber,
                            Long id);

    // update customer by full name and zip code
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET full_name = ?1, " +
            "address = ?2, " +
            "city = ?3, " +
            "state = ?4, " +
            "country = ?5, " +
            "phone_number = ?6 " +
            "WHERE full_name = ?7 " +
            "AND zip_code = ?8", nativeQuery = true)
    void updateCustomerByFullNameAndZipCode(String fullName,
                                            String address,
                                            String city,
                                            String state,
                                            String country,
                                            String phoneNumber,
                                            String fullName2,
                                            String zipCode);

    // update customer address
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET address = ?1 " +
            "WHERE id = ?2", nativeQuery = true)
    void updateCustomerAddress(String address, Long id);

    // update customer city
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET city = ?1 " +
            "WHERE id = ?2", nativeQuery = true)
    void updateCustomerCity(String city, Long id);

    // update customer state
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET state = ?1 " +
            "WHERE id = ?2", nativeQuery = true)
    void updateCustomerState(String state, Long id);

    // update customer zip code
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET zip_code = ?1 " +
            "WHERE id = ?2", nativeQuery = true)
    void updateCustomerZipCode(String zipCode, Long id);

    // update customer country
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET country = ?1 " +
            "WHERE id = ?2", nativeQuery = true)
    void updateCustomerCountry(String country, Long id);

    // update customer phone number
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET phone_number = ?1 " +
            "WHERE id = ?2", nativeQuery = true)
    void updateCustomerPhoneNumber(String phoneNumber, Long id);

    // update customer full name
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET full_name = ?1 " +
            "WHERE id = ?2", nativeQuery = true)
    void updateCustomerFullName(String fullName, Long id);

    // update customer full name and zip code
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET full_name = ?1, " +
            "zip_code = ?2 " +
            "WHERE id = ?3", nativeQuery = true)
    void updateCustomerFullNameAndZipCode(String fullName, String zipCode, Long id);

    // get customer by address and phone number
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE address = ?1 " +
            "AND phone_number = ?2", nativeQuery = true)
    List<CustomerDto> getCustomerByAddressAndPhoneNumber(String address, String phoneNumber);

    // get customer by first name and last name and remove the last name
    @Query(value =
            "SELECT * " +
            "FROM customer " +
            "WHERE full_name = ?1", nativeQuery = true)
    List<CustomerDto> getCustomerByFullName(String fullName);

    // update customer by id using the dto
    @Modifying
    @Query(value =
            "UPDATE customer " +
            "SET full_name = ?1, " +
            "address = ?2, " +
            "city = ?3, " +
            "state = ?4, " +
            "zip_code = ?5, " +
            "country = ?6, " +
            "phone_number = ?7 " +
            "WHERE id = ?8", nativeQuery = true)
    void updateCustomerById(Long id, CustomerDto customerDto);
}

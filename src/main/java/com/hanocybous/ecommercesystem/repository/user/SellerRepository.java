package com.hanocybous.ecommercesystem.repository.user;

import com.hanocybous.ecommercesystem.dto.user.SellerDto;
import com.hanocybous.ecommercesystem.entity.user.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface SellerRepository extends JpaRepository<Seller, Long> {

    // get seller by company name
    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE company_name = ?1", nativeQuery = true)
    List<SellerDto> getSellerByCompanyName(String companyName);

    // get seller by company address
    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE company_address = ?1", nativeQuery = true)
    List<SellerDto> getSellerByCompanyAddress(String companyAddress);

    // get seller by company phone number
    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE company_phone_number = ?1", nativeQuery = true)
    List<SellerDto> getSellerByCompanyPhoneNumber(String companyPhoneNumber);

    // get seller by company name and company address
    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE company_name = ?1 " +
            "AND company_address = ?2", nativeQuery = true)
    List<SellerDto> getSellerByCompanyNameAndCompanyAddress(String companyName,
                                                            String companyAddress);

    // get seller by company name and company phone number
    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE company_name = ?1 " +
            "AND company_phone_number = ?2", nativeQuery = true)
    List<SellerDto> getSellerByCompanyNameAndCompanyPhoneNumber(String companyName,
                                                                String companyPhoneNumber);

    // get seller by company address and company phone number
    @Query(value =
            "SELECT * " +
            "FROM seller " +
            "WHERE company_address = ?1 " +
            "AND company_phone_number = ?2", nativeQuery = true)
    List<SellerDto> getSellerByCompanyAddressAndCompanyPhoneNumber(String companyAddress,
                                                                   String companyPhoneNumber);

    // delete seller by company name
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM seller " +
            "WHERE company_name = ?1", nativeQuery = true)
    void deleteSellerByCompanyName(String companyName);

    // delete seller by company address
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM seller " +
            "WHERE company_address = ?1", nativeQuery = true)
    void deleteSellerByCompanyAddress(String companyAddress);

    // delete seller by company phone number
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM seller " +
            "WHERE company_phone_number = ?1", nativeQuery = true)
    void deleteSellerByCompanyPhoneNumber(String companyPhoneNumber);

    // delete seller by company name and company address
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM seller " +
            "WHERE company_name = ?1 " +
            "AND company_address = ?2", nativeQuery = true)
    void deleteSellerByCompanyNameAndCompanyAddress(String companyName,
                                                    String companyAddress);

    // update seller by company name
    @Modifying
    @Query(value =
            "UPDATE seller " +
            "SET company_name = ?2 " +
            "WHERE company_name = ?1", nativeQuery = true)
    void updateSellerByCompanyName(String companyName,
                                   String newCompanyName);

    // update seller by company address
    @Modifying
    @Query(value =
            "UPDATE seller " +
            "SET company_address = ?2 " +
            "WHERE company_address = ?1", nativeQuery = true)
    void updateSellerByCompanyAddress(String companyAddress,
                                      String newCompanyAddress);

    // update seller by company phone number
    @Modifying
    @Query(value =
            "UPDATE seller " +
            "SET company_phone_number = ?2 " +
            "WHERE company_phone_number = ?1", nativeQuery = true)
    void updateSellerByCompanyPhoneNumber(String companyPhoneNumber,
                                          String newCompanyPhoneNumber);

    // update seller by company name and company address
    @Modifying
    @Query(value =
            "UPDATE seller " +
            "SET company_name = ?2, " +
            "company_address = ?3 " +
            "WHERE company_name = ?1 " +
            "AND company_address = ?4", nativeQuery = true)
    void updateSellerByCompanyNameAndCompanyAddress(String companyName,
                                                    String newCompanyName,
                                                    String companyAddress,
                                                    String newCompanyAddress);


}

package com.hanocybous.ecommercesystem.repository.user;

import com.hanocybous.ecommercesystem.dto.user.AdminDto;
import com.hanocybous.ecommercesystem.entity.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface AdminRepository extends JpaRepository<Admin, Long> {

    // get admin by verification token
    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE verification_code = ?1", nativeQuery = true)
    List<AdminDto> getAdminByVerificationToken(Long verificationToken);

    // get admin by id and verification token
    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE id = ?1 " +
            "AND verification_code = ?2", nativeQuery = true)
    List<AdminDto> getAdminByIdAndVerificationToken(Long id, Long verificationToken);

    // get admin by username and verification token
    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE username = ?1 " +
            "AND verification_code = ?2", nativeQuery = true)
    List<AdminDto> getAdminByUsernameAndVerificationToken(String username, Long verificationToken);

    // get admin by email and verification token
    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE email = ?1 " +
            "AND verification_code = ?2", nativeQuery = true)
    List<AdminDto> getAdminByEmailAndVerificationToken(String email, Long verificationToken);

    // update admin verification token
    @Modifying
    @Query(value =
            "UPDATE admin " +
            "SET verification_code = ?1 " +
            "WHERE id = ?2", nativeQuery = true)
    void updateAdminVerificationToken(Long verificationToken, Long id);

    // update admin verification token by username
    @Modifying
    @Query(value =
            "UPDATE admin " +
            "SET verification_code = ?1 " +
            "WHERE username = ?2", nativeQuery = true)
    void updateAdminVerificationTokenByUsername(String username, Long verificationToken);

    // update admin verification token by email
    @Modifying
    @Query(value =
            "UPDATE admin " +
            "SET verification_code = ?1 " +
            "WHERE email = ?2", nativeQuery = true)
    void updateAdminVerificationTokenByEmail(String email, Long verificationToken);

    // update admin verification token by username
    @Modifying
    @Query(value =
            "UPDATE admin " +
            "SET verification_code = ?1 " +
            "WHERE username = ?2", nativeQuery = true)
    void updateAdminVerificationToken(String username, Long verificationToken);

}

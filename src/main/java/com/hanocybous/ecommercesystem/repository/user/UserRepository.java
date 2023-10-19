package com.hanocybous.ecommercesystem.repository.user;

import com.hanocybous.ecommercesystem.dto.user.UserDto;
import com.hanocybous.ecommercesystem.entity.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE username = ?1", nativeQuery = true)
    List<UserDto> getAdminByUsername(String username);

    @Query(value =
            "SELECT * " +
            "FROM admin " +
            "WHERE email = ?1", nativeQuery = true)
    List<UserDto> getAdminByEmail(String email);

    
}

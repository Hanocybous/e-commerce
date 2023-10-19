package com.hanocybous.ecommercesystem.service.user;

import com.hanocybous.ecommercesystem.dto.user.AdminDto;
import com.hanocybous.ecommercesystem.repository.user.AdminRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Getter
@SuppressWarnings("unused")
public class AdminService implements IAdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // get admin by verification token
    public List<AdminDto> getAdminByVerificationToken(Long verificationToken) {
        if (verificationToken == null || verificationToken == 0 || verificationToken < 0) {
            return Collections.emptyList();
        }
        return adminRepository.getAdminByVerificationToken(verificationToken);
    }

    // get admin by id and verification token
    public List<AdminDto> getAdminByIdAndVerificationToken(Long id, Long verificationToken) {
        if (id == null || id == 0 || id < 0) {
            return Collections.emptyList();
        }
        if (verificationToken == null || verificationToken == 0 || verificationToken < 0) {
            return Collections.emptyList();
        }
        return adminRepository.getAdminByIdAndVerificationToken(id, verificationToken);
    }

    // get admin by username and verification token
    public List<AdminDto> getAdminByUsernameAndVerificationToken(String username, Long verificationToken) {
        if (username == null || username.isEmpty()) {
            return Collections.emptyList();
        }
        if (verificationToken == null || verificationToken == 0 || verificationToken < 0) {
            return Collections.emptyList();
        }
        return adminRepository.getAdminByUsernameAndVerificationToken(username, verificationToken);
    }

    // get admin by email and verification token
    public List<AdminDto> getAdminByEmailAndVerificationToken(String email, Long verificationToken) {
        if (email == null || email.isEmpty()) {
            return Collections.emptyList();
        }
        if (verificationToken == null || verificationToken == 0 || verificationToken < 0) {
            return Collections.emptyList();
        }
        return adminRepository.getAdminByEmailAndVerificationToken(email, verificationToken);
    }

    // update admin verification token
    public void updateAdminVerificationToken(Long id, Long verificationToken) {
        if (id == null || id == 0 || id < 0) {
            return;
        }
        if (verificationToken == null || verificationToken == 0 || verificationToken < 0) {
            return;
        }
        adminRepository.updateAdminVerificationToken(id, verificationToken);
    }

}
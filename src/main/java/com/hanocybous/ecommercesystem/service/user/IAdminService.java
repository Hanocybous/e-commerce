package com.hanocybous.ecommercesystem.service.user;

import com.hanocybous.ecommercesystem.dto.user.AdminDto;

import java.util.List;

public interface IAdminService {

    List<AdminDto> getAdminByVerificationToken(Long verificationToken);

    List<AdminDto> getAdminByIdAndVerificationToken(Long id, Long verificationToken);

    List<AdminDto> getAdminByUsernameAndVerificationToken(String username, Long verificationToken);

    List<AdminDto> getAdminByEmailAndVerificationToken(String email, Long verificationToken);

}

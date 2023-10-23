package com.hanocybous.ecommercesystem.controller.user;

import com.hanocybous.ecommercesystem.dto.user.AdminDto;

import java.util.List;

public interface IAdminController {

    List<AdminDto> getAdminByVerificationToken(Long verificationToken);

    List<AdminDto> getAdminByIdAndVerificationToken(Long id, Long verificationToken);

    List<AdminDto> getAdminByUsernameAndVerificationToken(String username, Long verificationToken);

    List<AdminDto> getAdminByEmailAndVerificationToken(String email, Long verificationToken);

    void updateAdminVerificationToken(Long id, Long verificationToken);

    void updateAdminVerificationToken(String username, Long verificationToken);


}

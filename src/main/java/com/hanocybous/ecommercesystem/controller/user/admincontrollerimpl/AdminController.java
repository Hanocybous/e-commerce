package com.hanocybous.ecommercesystem.controller.user.admincontrollerimpl;

import com.hanocybous.ecommercesystem.controller.user.IAdminController;
import com.hanocybous.ecommercesystem.dto.user.AdminDto;
import com.hanocybous.ecommercesystem.service.user.adminimpl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/admin")
public class AdminController implements IAdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAdminByVerificationToken/{verificationToken}")
    @ResponseBody
    public List<AdminDto> getAdminByVerificationToken(
            @RequestBody
            @PathVariable Long verificationToken) {
        return adminService.getAdminByVerificationToken(verificationToken);
    }

    @GetMapping("/getAdminByIdAndVerificationToken/{id}/{verificationToken}")
    @ResponseBody
    public List<AdminDto> getAdminByIdAndVerificationToken(
            @RequestBody
            @PathVariable Long id,
            @PathVariable Long verificationToken) {
        return adminService.getAdminByIdAndVerificationToken(id, verificationToken);
    }

    @GetMapping("/getAdminByUsernameAndVerificationToken/{username}/{verificationToken}")
    @ResponseBody
    public List<AdminDto> getAdminByUsernameAndVerificationToken(
            @RequestBody
            @PathVariable String username,
            @PathVariable Long verificationToken) {
        return adminService.getAdminByUsernameAndVerificationToken(username, verificationToken);
    }

    @GetMapping("/getAdminByEmailAndVerificationToken/{email}/{verificationToken}")
    @ResponseBody
    public List<AdminDto> getAdminByEmailAndVerificationToken(
            @RequestBody
            @PathVariable String email,
            @PathVariable Long verificationToken) {
        return adminService.getAdminByEmailAndVerificationToken(email, verificationToken);
    }

    @PostMapping("/updateAdminVerificationToken/{id}/{verificationToken}")
    @ResponseBody
    public void updateAdminVerificationToken(
            @RequestBody
            @PathVariable Long id,
            @PathVariable Long verificationToken) {
        adminService.updateAdminVerificationToken(id, verificationToken);
    }

    @Override
    public void updateAdminVerificationToken(
            @RequestBody
            @PathVariable String username,
            @PathVariable Long verificationToken) {
        adminService.updateAdminVerificationToken(username, verificationToken);
    }

    @PostMapping("/updateAdminVerificationTokenByUsername/{username}/{verificationToken}")
    @ResponseBody
    public void updateAdminVerificationTokenByUsername(
            @RequestBody
            @PathVariable String username,
            @PathVariable Long verificationToken) {
        adminService.updateAdminVerificationTokenByUsername(username, verificationToken);
    }

    @PostMapping("/updateAdminVerificationTokenByEmail/{email}/{verificationToken}")
    @ResponseBody
    public void updateAdminVerificationTokenByEmail(
            @RequestBody
            @PathVariable String email,
            @PathVariable Long verificationToken) {
        adminService.updateAdminVerificationTokenByEmail(email, verificationToken);
    }

}

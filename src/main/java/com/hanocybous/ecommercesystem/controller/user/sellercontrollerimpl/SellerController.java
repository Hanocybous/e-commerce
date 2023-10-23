package com.hanocybous.ecommercesystem.controller.user.sellercontrollerimpl;

import com.hanocybous.ecommercesystem.controller.user.ISellerController;
import com.hanocybous.ecommercesystem.dto.user.SellerDto;
import com.hanocybous.ecommercesystem.service.user.sellerimpl.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/seller")
public class SellerController implements ISellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/companyName/{companyName}")
    @ResponseBody
    public List<SellerDto> getSellerByCompanyName(
            @RequestBody
            @PathVariable String companyName) {
        return sellerService.getSellerByCompanyName(companyName);
    }

    @GetMapping("/companyAddress/{companyAddress}")
    @ResponseBody
    public List<SellerDto> getSellerByCompanyAddress(
            @RequestBody
            @PathVariable String companyAddress) {
        return sellerService.getSellerByCompanyAddress(companyAddress);
    }

    @GetMapping("/companyPhoneNumber/{companyPhoneNumber}")
    @ResponseBody
    public List<SellerDto> getSellerByCompanyPhoneNumber(
            @RequestBody
            @PathVariable String companyPhoneNumber) {
        return sellerService.getSellerByCompanyPhoneNumber(companyPhoneNumber);
    }

    @GetMapping("/companyName/{companyName}/companyAddress/{companyAddress}")
    @ResponseBody
    public List<SellerDto> getSellerByCompanyNameAndCompanyAddress(
            @RequestBody
            @PathVariable String companyName,
            @RequestBody
            @PathVariable String companyAddress) {
        return sellerService.getSellerByCompanyNameAndCompanyAddress(companyName, companyAddress);
    }

    @GetMapping("/companyName/{companyName}/companyPhoneNumber/{companyPhoneNumber}")
    @ResponseBody
    public List<SellerDto> getSellerByCompanyNameAndCompanyPhoneNumber(
            @RequestBody
            @PathVariable String companyName,
            @RequestBody
            @PathVariable String companyPhoneNumber) {
        return sellerService.getSellerByCompanyNameAndCompanyPhoneNumber(companyName, companyPhoneNumber);
    }

    @GetMapping("/companyAddress/{companyAddress}/companyPhoneNumber/{companyPhoneNumber}")
    @ResponseBody
    public List<SellerDto> getSellerByCompanyAddressAndCompanyPhoneNumber(
            @RequestBody
            @PathVariable String companyAddress,
            @RequestBody
            @PathVariable String companyPhoneNumber) {
        return sellerService.getSellerByCompanyAddressAndCompanyPhoneNumber(companyAddress, companyPhoneNumber);
    }

    @DeleteMapping("/companyName/{companyName}")
    @ResponseBody
    public void deleteSellerByCompanyName(
            @RequestBody
            @PathVariable String companyName) {
        sellerService.deleteSellerByCompanyName(companyName);
    }

    @DeleteMapping("/companyAddress/{companyAddress}")
    @ResponseBody
    public void deleteSellerByCompanyAddress(
            @RequestBody
            @PathVariable String companyAddress) {
        sellerService.deleteSellerByCompanyAddress(companyAddress);
    }

    @DeleteMapping("/companyPhoneNumber/{companyPhoneNumber}")
    @ResponseBody
    public void deleteSellerByCompanyPhoneNumber(
            @RequestBody
            @PathVariable String companyPhoneNumber) {
        sellerService.deleteSellerByCompanyPhoneNumber(companyPhoneNumber);
    }

    @DeleteMapping("/companyName/{companyName}/companyAddress/{companyAddress}")
    @ResponseBody
    public void deleteSellerByCompanyNameAndCompanyAddress(
            @RequestBody
            @PathVariable String companyName,
            @RequestBody
            @PathVariable String companyAddress) {
        sellerService.deleteSellerByCompanyNameAndCompanyAddress(companyName, companyAddress);
    }

    @PostMapping("/companyName/{companyName}/companyAddress/{companyAddress}")
    @ResponseBody
    public void updateSellerByCompanyName(
            @RequestBody
            @PathVariable String companyName,
            @RequestBody
            @PathVariable String companyAddress) {
        sellerService.updateSellerByCompanyName(companyName, companyAddress);
    }

    @PostMapping("/companyName/{companyName}/companyPhoneNumber/{companyPhoneNumber}")
    @ResponseBody
    public void updateSellerByCompanyAddress(
            @RequestBody
            @PathVariable String companyName,
            @RequestBody
            @PathVariable String companyPhoneNumber) {
        sellerService.updateSellerByCompanyAddress(companyName, companyPhoneNumber);
    }

    @PostMapping("/companyAddress/{companyAddress}/companyPhoneNumber/{companyPhoneNumber}")
    @ResponseBody
    public void updateSellerByCompanyPhoneNumber(
            @RequestBody
            @PathVariable String companyAddress,
            @RequestBody
            @PathVariable String companyPhoneNumber) {
        sellerService.updateSellerByCompanyPhoneNumber(companyAddress, companyPhoneNumber);
    }

}

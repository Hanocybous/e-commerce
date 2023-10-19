package com.hanocybous.ecommercesystem.service.user;

import com.hanocybous.ecommercesystem.dto.user.SellerDto;

import java.util.List;

public interface ISellerService {

    List<SellerDto> getSellerByCompanyName(String companyName);

    List<SellerDto> getSellerByCompanyAddress(String companyAddress);

    List<SellerDto> getSellerByCompanyPhoneNumber(String companyPhoneNumber);

    List<SellerDto> getSellerByCompanyNameAndCompanyAddress(String companyName,
                                                            String companyAddress);

    List<SellerDto> getSellerByCompanyNameAndCompanyPhoneNumber(String companyName,
                                                                String companyPhoneNumber);

    List<SellerDto> getSellerByCompanyAddressAndCompanyPhoneNumber(String companyAddress,
                                                                   String companyPhoneNumber);
    
}

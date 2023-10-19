package com.hanocybous.ecommercesystem.service.user;

import com.hanocybous.ecommercesystem.dto.user.SellerDto;
import com.hanocybous.ecommercesystem.repository.user.SellerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Getter
@SuppressWarnings("unused")
public class SellerService implements ISellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    // get seller by company name
    public List<SellerDto> getSellerByCompanyName(String companyName) {
        if (companyName == null || companyName.isEmpty()) {
            return Collections.emptyList();
        }
        return sellerRepository.getSellerByCompanyName(companyName);
    }

    // get seller by company address
    public List<SellerDto> getSellerByCompanyAddress(String companyAddress) {
        if (companyAddress == null || companyAddress.isEmpty()) {
            return Collections.emptyList();
        }
        return sellerRepository.getSellerByCompanyAddress(companyAddress);
    }

    // get seller by company phone number
    public List<SellerDto> getSellerByCompanyPhoneNumber(String companyPhoneNumber) {
        if (companyPhoneNumber == null ||
                companyPhoneNumber.isEmpty()) {
            return Collections.emptyList();
        }
        return sellerRepository.getSellerByCompanyPhoneNumber(companyPhoneNumber);
    }

    // get seller by company name and company address
    public List<SellerDto> getSellerByCompanyNameAndCompanyAddress(String companyName,
                                                                   String companyAddress) {
        if (companyName == null ||
                companyName.isEmpty() ||
                companyAddress == null ||
                companyAddress.isEmpty()) {
            return Collections.emptyList();
        }
        return sellerRepository.getSellerByCompanyNameAndCompanyAddress(companyName, companyAddress);
    }

    // get seller by company name and company phone number
    public List<SellerDto> getSellerByCompanyNameAndCompanyPhoneNumber(String companyName,
                                                                       String companyPhoneNumber) {
        if (companyName == null ||
                companyName.isEmpty() ||
                companyPhoneNumber == null ||
                companyPhoneNumber.isEmpty()) {
            return Collections.emptyList();
        }
        return sellerRepository.getSellerByCompanyNameAndCompanyPhoneNumber(companyName,
                companyPhoneNumber);
    }

    // get seller by company address and company phone number
    public List<SellerDto> getSellerByCompanyAddressAndCompanyPhoneNumber(String companyAddress,
                                                                          String companyPhoneNumber) {
        if (companyAddress == null ||
                companyAddress.isEmpty() ||
                companyPhoneNumber == null ||
                companyPhoneNumber.isEmpty()) {
            return Collections.emptyList();
        }
        return sellerRepository.getSellerByCompanyAddressAndCompanyPhoneNumber(companyAddress,
                companyPhoneNumber);
    }

    // delete seller by company name
    public void deleteSellerByCompanyName(String companyName) {
        if (companyName == null ||
                companyName.isEmpty()) {
            return;
        }
        sellerRepository.deleteSellerByCompanyName(companyName);
    }

    // delete seller by company address
    public void deleteSellerByCompanyAddress(String companyAddress) {
        if (companyAddress == null ||
                companyAddress.isEmpty()) {
            return;
        }
        sellerRepository.deleteSellerByCompanyAddress(companyAddress);
    }

    // delete seller by company phone number
    public void deleteSellerByCompanyPhoneNumber(String companyPhoneNumber) {
        if (companyPhoneNumber == null ||
                companyPhoneNumber.isEmpty()) {
            return;
        }
        sellerRepository.deleteSellerByCompanyPhoneNumber(companyPhoneNumber);
    }

    // delete seller by company name and company address
    public void deleteSellerByCompanyNameAndCompanyAddress(String companyName,
                                                           String companyAddress) {
        if (companyName == null ||
                companyName.isEmpty() ||
                companyAddress == null ||
                companyAddress.isEmpty()) {
            return;
        }
        sellerRepository.deleteSellerByCompanyNameAndCompanyAddress(companyName,
                companyAddress);
    }

    // update seller by company name
    public void updateSellerByCompanyName(String companyName,
                                          String companyAddress) {
        if (companyName == null ||
                companyName.isEmpty() ||
                companyAddress == null ||
                companyAddress.isEmpty()) {
            return;
        }
        sellerRepository.updateSellerByCompanyName(companyName,
                companyAddress);
    }

    // update seller by company address
    public void updateSellerByCompanyAddress(String companyAddress,
                                             String companyPhoneNumber) {
        if (companyAddress == null ||
                companyAddress.isEmpty() ||
                companyPhoneNumber == null ||
                companyPhoneNumber.isEmpty()) {
            return;
        }
        sellerRepository.updateSellerByCompanyAddress(companyAddress,
                companyPhoneNumber);
    }

    // update seller by company phone number
    public void updateSellerByCompanyPhoneNumber(String companyPhoneNumber,
                                                 String companyName) {
        if (companyPhoneNumber == null ||
                companyPhoneNumber.isEmpty() ||
                companyName == null ||
                companyName.isEmpty()) {
            return;
        }
        sellerRepository.updateSellerByCompanyPhoneNumber(companyPhoneNumber,
                companyName);
    }

}

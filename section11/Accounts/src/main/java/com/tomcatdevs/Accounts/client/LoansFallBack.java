package com.tomcatdevs.Accounts.client;

import com.tomcatdevs.Accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallBack implements LoansFeignClient{
    /**
     * note--> fetching loan detail by passing mobile number
     *
     * @param correlationId
     * @param mobileNumber
     **/
    @Override
    public ResponseEntity<LoansDto> fetchLoans(String correlationId, String mobileNumber) {
        return null;
    }
}

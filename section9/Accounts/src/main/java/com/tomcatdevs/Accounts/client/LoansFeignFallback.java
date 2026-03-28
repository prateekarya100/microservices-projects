package com.tomcatdevs.Accounts.client;

import com.tomcatdevs.Accounts.common.ServiceResponse;
import com.tomcatdevs.Accounts.dto.LoansDto;
import org.springframework.stereotype.Component;

@Component
public class LoansFeignFallback implements LoansFeignClient {

    @Override
    public ServiceResponse<LoansDto> fetchLoans(String mobileNumber) {
        return new ServiceResponse<>(
                "LOANS",
                "DOWN",
                "loans service is currently unavailable to serve your request at this moment, please try again later",
                null // if no validation triggered
        );
    }
}
package com.tomcatdevs.Accounts.client;

import com.tomcatdevs.Accounts.common.ServiceResponse;
import com.tomcatdevs.Accounts.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "loans",
        fallback = LoansFeignFallback.class
)
public interface LoansFeignClient {

    @GetMapping("/api/fetchLoan")
    ServiceResponse<LoansDto> fetchLoans(@RequestParam String mobileNumber);
}
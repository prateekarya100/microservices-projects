package com.tomcatdevs.Accounts.client;

import com.tomcatdevs.Accounts.common.ServiceResponse;
import com.tomcatdevs.Accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "cards",
        fallback = CardsFeignFallback.class
)
public interface CardsFeignClient {

    @GetMapping("/api/fetch-card-by-mobileNumber")
    ServiceResponse<CardsDto> fetchCardByMobileNumber(@RequestParam String mobileNumber);
}
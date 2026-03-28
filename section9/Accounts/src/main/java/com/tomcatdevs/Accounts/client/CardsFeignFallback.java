package com.tomcatdevs.Accounts.client;

import com.tomcatdevs.Accounts.common.ServiceResponse;
import com.tomcatdevs.Accounts.dto.CardsDto;
import org.springframework.stereotype.Component;

@Component
public class CardsFeignFallback implements CardsFeignClient {

    @Override
    public ServiceResponse<CardsDto> fetchCardByMobileNumber(String mobileNumber) {
        return new ServiceResponse<>(
                "CARDS",
                "DOWN",
                "cards service is currently unavailable to serve your request at this moment, please try again later",
                null  // if no validation triggered
        );
    }
}
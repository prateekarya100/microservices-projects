package com.tomcatdevs.Accounts.service.client;

import com.tomcatdevs.Accounts.client.CardsFeignClient;
import com.tomcatdevs.Accounts.client.LoansFeignClient;
import com.tomcatdevs.Accounts.dto.AccountsDto;
import com.tomcatdevs.Accounts.dto.CardsDto;
import com.tomcatdevs.Accounts.dto.ConsolidatedCustomerDetailsDTO;
import com.tomcatdevs.Accounts.dto.LoansDto;
import com.tomcatdevs.Accounts.exception.ResourceNotFoundException;
import com.tomcatdevs.Accounts.mapper.AccountsMapper;
import com.tomcatdevs.Accounts.mapper.CustomerMapper;
import com.tomcatdevs.Accounts.model.Accounts;
import com.tomcatdevs.Accounts.model.Customer;
import com.tomcatdevs.Accounts.repository.AccountsRepository;
import com.tomcatdevs.Accounts.repository.CustomerRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IConsolidatedServiceImpl implements IConsolidatedService{

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;


    // calling to get data from cards,loans microservices
    @Autowired
    private CardsFeignClient cardsFeignClient;

    @Autowired
    public LoansFeignClient loansFeignClient;

    @Override
    public Optional<ConsolidatedCustomerDetailsDTO> fetchConsolidatedInfo(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("customer","mobile number",mobileNumber));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("accounts","customerId",customer.getCustomerId().toString()));

        ConsolidatedCustomerDetailsDTO customerDetailsDTO = CustomerMapper.mapToConsolidatedInfoDTO(customer,new ConsolidatedCustomerDetailsDTO());
        customerDetailsDTO.setAccountsDto(AccountsMapper.mapAccountsToDto(accounts,new AccountsDto()));

        System.out.println(cardsFeignClient.fetchCardByMobileNumber(mobileNumber).getData());
        System.out.println(loansFeignClient.fetchLoans(mobileNumber).getData());

        customerDetailsDTO.setCardsDto(cardsFeignClient.fetchCardByMobileNumber(mobileNumber).getData());
        customerDetailsDTO.setLoansDto(loansFeignClient.fetchLoans(mobileNumber).getData());

        return Optional.of(customerDetailsDTO);
    }


//    @CircuitBreaker(name = "accountsServiceCardsCall", fallbackMethod = "cardsFallback")
//    public CardsDto getCards(String mobileNumber) {
//        return cardsFeignClient.fetchCardByMobileNumber(mobileNumber).getData();
//    }
//
//    @CircuitBreaker(name = "accountsServiceLoansCall", fallbackMethod = "loansFallback")
//    public LoansDto getLoans(String mobileNumber) {
//        return loansFeignClient.fetchLoans(mobileNumber).getData();
//    }

//    public ResponseEntity<Map<String, Object>> cardsFallback(String mobileNumber, Throwable t) {
//        Map<String, Object> fallback = new HashMap<>();
//        fallback.put("mobileNumber", mobileNumber);
//        fallback.put("message", "Cards service is currently unavailable");
//        fallback.put("errorTime", LocalDateTime.now());
//        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallback);
//    }
//
//    public ResponseEntity<Map<String, Object>> loansFallback(String mobileNumber, Throwable t) {
//        Map<String, Object> fallback = new HashMap<>();
//        fallback.put("mobileNumber", mobileNumber);
//        fallback.put("message", "Loans service is currently unavailable");
//        fallback.put("errorTime", LocalDateTime.now());
//        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallback);
//    }

}

package com.tomcatdevs.Accounts.common;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ServiceResponse<T> {

    private String service;     // cards / loans
    private String status;      // UP / DOWN / PARTIAL
    private String message;     // error message if any
    private T data;             // actual DTO
}
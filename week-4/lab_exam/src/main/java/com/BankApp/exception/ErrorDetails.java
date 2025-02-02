package com.BankApp.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetails
{
    private String message;
    private String details;
    private int status;
    private String timestamp;
    private String contactEmail;

}

package com.koerber.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionErrorDetails
{
    private long timeStamp;
    private String message;
    private String details;
    private String supportEmail;

}

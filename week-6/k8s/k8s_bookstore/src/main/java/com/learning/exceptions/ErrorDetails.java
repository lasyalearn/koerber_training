package com.learning.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetails
{
    private String message;
    private String details;
    private long timestamp;
    private String supportEmail;
}

package com.mountains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ascents
{
    private FirstAscend first;
    private FirstAscend firstWinter;
    private int total;
}
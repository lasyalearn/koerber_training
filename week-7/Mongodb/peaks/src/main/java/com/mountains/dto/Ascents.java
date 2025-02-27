package com.mountains.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ascents
{
    private FirstAscend first;
    private FirstAscend first_winter;
    private int total;
}
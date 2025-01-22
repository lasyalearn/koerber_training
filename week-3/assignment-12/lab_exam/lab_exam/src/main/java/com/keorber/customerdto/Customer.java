package com.keorber.customerdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer
{
    private int id;
    private String name;
    private String address;
    private String phone_no;
}

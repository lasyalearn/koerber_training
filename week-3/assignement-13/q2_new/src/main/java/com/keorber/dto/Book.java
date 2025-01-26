package com.keorber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book
{
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;
}

package com.keorber.dto;
import lombok.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book
{
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;

}

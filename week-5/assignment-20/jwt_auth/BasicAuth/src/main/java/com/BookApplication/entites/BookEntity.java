package com.BookApplication.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookEntity
{
    // validation is applied to this layer but i haven't
    // the dependencies hence not using and focusing on the basic auth
    private int id;
    private String title;
    private String author;
    private double price;

}

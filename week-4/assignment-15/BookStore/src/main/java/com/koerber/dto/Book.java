package com.koerber.dto;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book
{
    //JSR 303
    // rules to validate the values given to the variables
    // no rule for id
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @Column(name = "isbn")
    @NotEmpty(message = "ISBN is required")
    private String isbn;
    @Column(name = "title")
    @NotEmpty(message = "Title is required")
    private String title;
    @Column(name = "author")
    @NotEmpty(message = "Author is required")
    private String author;
    @Column(name = "price")
    @Range(min=100,max=1000, message = "Book must be within the price limit of 100 to 1000")
    @NotNull(message = "Price is required")
    private BigDecimal price;

}

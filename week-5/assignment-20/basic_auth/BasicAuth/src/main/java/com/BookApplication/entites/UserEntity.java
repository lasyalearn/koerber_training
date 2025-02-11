package com.BookApplication.entites;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_table")
@Data
@NoArgsConstructor
@ToString
public class UserEntity
{
    // security it seems already has a table for user
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "role_table")

    private List<String> roles = new ArrayList<>();

    public UserEntity(String username, String password, List<String> roles)
    {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}

package com.example.uerinfo.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private Integer sex;
}

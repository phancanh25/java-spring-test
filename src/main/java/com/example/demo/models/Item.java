package com.example.demo.models;

import lombok.Data;

@Data
public class Item {
    Long id;
    //relation ManyToOne with User
    Long userId;
    String name;
    String description;
}

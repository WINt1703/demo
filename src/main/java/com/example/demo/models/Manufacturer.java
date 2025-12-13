package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    private long id;

    private String title;

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


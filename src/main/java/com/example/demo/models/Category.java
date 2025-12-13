package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    private long id;

    private String title;

    public long getId() {
        return this.id;
    }

    public void setId(long categoryId) {
        this.id = categoryId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
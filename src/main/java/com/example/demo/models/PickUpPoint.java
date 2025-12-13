package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pickup_point")
public class PickUpPoint {
    @Id
    private long id;

    private String address;

    public long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.address;
    }

    public void setTitle(String address) {
        this.address = address;
    }
}

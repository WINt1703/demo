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

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

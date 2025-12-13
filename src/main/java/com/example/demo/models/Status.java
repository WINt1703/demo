package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "status")
public class Status {
    @Id
    private long id;

    private String title;

    @OneToMany(mappedBy = "status")
    private Set<Order> orders;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}

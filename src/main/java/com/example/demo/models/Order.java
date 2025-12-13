package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private Status status = Status.NEW;

    @ManyToOne
    @JoinColumn(name = "pickuppoint_id")
    private PickUpPoint pickUpPoint;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    private String username;

    @Column(name = "get_code", insertable = false, updatable = false)
    private int getCode;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderProduct> orderProducts = new HashSet<>();

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PickUpPoint getPickUpPoint() {
        return this.pickUpPoint;
    }

    public void setPickUpPoint(PickUpPoint pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(LocalDate create_date) {
        this.createDate = create_date;
    }

    public LocalDate getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGetCode() {
        return this.getCode;
    }

    public void setGetCode(int getCode) {
        this.getCode = getCode;
    }

    public void addOrderProduct(OrderProduct op) {
        this.orderProducts.add(op);
        op.setOrder(this);
    }

    public void removeOrderProduct(OrderProduct op) {
        this.orderProducts.remove(op);
        op.setOrder(null);
    }

    public Set<OrderProduct> getOrderProducts() {
        return this.orderProducts;
    }
}

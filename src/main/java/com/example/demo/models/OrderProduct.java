package com.example.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "order_product")
public class OrderProduct {

    @Embeddable
    public record OrderProductId(@Column(name = "order_id") long orderId, @Column(name = "product_id") String productId) implements Serializable {}

    @EmbeddedId
    private OrderProductId orderProductId;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    private long count;

    public OrderProductId getOrderProductId() {
        return this.orderProductId;
    }

    public void setOrderProductId(OrderProductId orderProductId) {
        this.orderProductId = orderProductId;
    }

    public long getCount() {
        return this.count;
    }

    public void plusCount(long count) {
        this.count = this.count + count >= 0 ? this.count + count : 0;
    }
    public void minusCount(long count) {
        this.count = this.count - count >= 0 ? this.count - count : 0;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

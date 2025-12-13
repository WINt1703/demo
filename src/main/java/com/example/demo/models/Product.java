package com.example.demo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String title;

    private String description;

    private double cost;

    @Column(name = "max_discount_amount")
    private int maxDiscountAmount;

    @Column(name = "discount_amount")
    private int discountAmount;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unittype_id")
    private UnitType unitType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private byte[] photo;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderProduct> orderProducts = new HashSet<>();

    public String getId() {
        return this.id;
    }

    public void setId(String productId) {
        this.id = productId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxDiscountAmount() {
        return this.maxDiscountAmount;
    }

    public void setMaxDiscountAmount(Integer maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getQuantityInStock() {
        return this.quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public UnitType getUnitType() {
        return this.unitType;
    }

    public void setUnitType(UnitType unittype) {
        this.unitType = unittype;
    }

    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void addOrderProduct(OrderProduct op) {
        this.orderProducts.add(op);
        op.setProduct(this);
    }

    public void removeOrderProduct(OrderProduct op) {
        this.orderProducts.remove(op);
        op.setProduct(null);
    }
}

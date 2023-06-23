package com.example.demo.products;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private LocalDate creationDate;
    private Integer yearsAntiguaty;

    public Product() {
    }

    public Product(Long id, String name, Double price, LocalDate creationDate, Integer yearsAntiguaty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.creationDate = creationDate;
        this.yearsAntiguaty = yearsAntiguaty;
    }

    public Product(String name, Double price, LocalDate creationDate, Integer yearsAntiguaty) {
        this.name = name;
        this.price = price;
        this.creationDate = creationDate;
        this.yearsAntiguaty = yearsAntiguaty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getYearsAntiguaty() {
        return yearsAntiguaty;
    }

    public void setYearsAntiguaty(Integer yearsAntiguaty) {
        this.yearsAntiguaty = yearsAntiguaty;
    }
}


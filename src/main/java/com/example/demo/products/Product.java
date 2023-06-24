package com.example.demo.products;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Double price;
    private LocalDate creationDate;
    @Transient
    private Integer yearsAntiguaty;

    public Product() {
    }

    public Product(Long id, String name, Double price, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.creationDate = creationDate;
    }

    public Product(String name, Double price, LocalDate creationDate) {
        this.name = name;
        this.price = price;
        this.creationDate = creationDate;
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
        return Period.between(this.creationDate, LocalDate.now() ).getYears();
    }

    public void setYearsAntiguaty(Integer yearsAntiguaty) {
        this.yearsAntiguaty = yearsAntiguaty;
    }
}


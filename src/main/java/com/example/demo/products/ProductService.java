package com.example.demo.products;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts(){
        return List.of(
                new Product(
                        1L,
                        "Macbook",
                        1000.0,
                        LocalDate.of(2023, Month.OCTOBER, 26),
                        2
                ),
        new Product(
                1L,
                "Asus 1020",
                900.0,
                LocalDate.of(2023, Month.DECEMBER, 20),
                1
        )
        );
    }
}

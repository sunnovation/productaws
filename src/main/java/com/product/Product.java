package com.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    private Integer id;
    private String productName;
    private String productId;
    private Double price;
    private String category;
    private LocalDate crdt;
    private LocalDate expDt;


}

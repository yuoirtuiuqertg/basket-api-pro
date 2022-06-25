package com.example.baskett.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "productList")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "list")
    private String list;
    @Column(name = "price")
    private int price;
    @Column(name = "count")
    private int count;
}

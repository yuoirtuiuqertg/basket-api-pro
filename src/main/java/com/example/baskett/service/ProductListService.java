package com.example.baskett.service;

import com.example.baskett.model.Basket;
import com.example.baskett.model.ProductList;
import com.example.baskett.repositorie.BasketRepositorie;
import com.example.baskett.repositorie.ProductListRepositorie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class ProductListService {
    private final ProductListRepositorie productListRepositorie;
    private final BasketRepositorie basketRepositories;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public List<ProductList> listProduct() {
        List<ProductList> products = productListRepositorie.findAll();
        return products;
    }
    public void getCheck(){
        List<Basket> products = basketRepositories.findAll();
        ProductList productList = new ProductList();
        String json = "";
        for(int i = 0; i < products.size(); i++){
            json += GSON.toJson(products.get(i));
        }
        productList.setList(json);
        productList.setCount(getBasketAllCount());
        productList.setPrice(getBasketAllPrice());
        productListRepositorie.save(productList);
    }

    public int getBasketAllPrice(){
        int price = 0;
        List<Basket> products = basketRepositories.findAll();
        for (int i = 0 ; i< products.size();i++){
            price += products.get(i).getPrice();
        }
        return price;
    }
    public int getBasketAllCount(){
        int count = 0;
        List<Basket> products = basketRepositories.findAll();
        for (int i = 0 ; i< products.size();i++){
            count += products.get(i).getCount();
        }
        return count;
    }


}



    /*Basket basket = new Basket();
            basket.setId(products.get(i).getId());
                    basket.setTitle(products.get(i).getTitle());
                    basket.setName(products.get(i).getName());
                    basket.setPrice(products.get(i).getPrice());
                    basket.setCount(products.get(i).getCount());*/
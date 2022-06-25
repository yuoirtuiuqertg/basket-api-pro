package com.example.baskett.service;

import com.example.baskett.model.Basket;
import com.example.baskett.repositorie.BasketRepositorie;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class BasketService {
    private final BasketRepositorie basketRepositories;
    public List<Basket> listBasket(String title) {
        List<Basket> products = basketRepositories.findAll();
        if(title != null) basketRepositories.findByName(title);
        return products;
    }
    public List<Basket> listBasketALL() {
        List<Basket> products = basketRepositories.findAll();
        return products;
    }


    public void updateItemCount(Long id, int count){
        Basket basketUpdateCount = basketRepositories.getOne(id);
        basketUpdateCount.setCount(basketUpdateCount.getCount() + count);
        basketRepositories.save(basketUpdateCount);

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

    public void saveBasket(Basket product) {
        log.info("Saving ne {}",product);
        basketRepositories.save(product);

    }


    public void deleteBasket(Long id) {
        basketRepositories.deleteById(id);
    }

    public void deleteAllBasket() {
        basketRepositories.deleteAll();
    }

}

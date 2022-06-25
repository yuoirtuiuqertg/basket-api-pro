package com.example.baskett.repositorie;

import com.example.baskett.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BasketRepositorie extends JpaRepository<Basket , Long> {
    List<Basket> findByName(String name);

}

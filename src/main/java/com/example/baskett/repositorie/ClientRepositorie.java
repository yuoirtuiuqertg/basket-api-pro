package com.example.baskett.repositorie;

import com.example.baskett.model.Basket;
import com.example.baskett.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepositorie extends JpaRepository<Client, Long> {
    List<Client> findByAuntification (String auntification);

}

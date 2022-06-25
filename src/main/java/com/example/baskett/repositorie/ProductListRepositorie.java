package com.example.baskett.repositorie;

import com.example.baskett.model.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductListRepositorie extends JpaRepository<ProductList,Long> {
    List<ProductList> findByList(String list);
}

package com.livecoding.livecodingdto.repository;

import com.livecoding.livecodingdto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product , Long> {
}

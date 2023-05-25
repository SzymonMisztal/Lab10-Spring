package com.johanes.labshop.data;

import com.johanes.labshop.Objects.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {}

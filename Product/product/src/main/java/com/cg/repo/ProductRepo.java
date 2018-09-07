package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.Product;

public interface ProductRepo extends JpaRepository<Product,String> {

}

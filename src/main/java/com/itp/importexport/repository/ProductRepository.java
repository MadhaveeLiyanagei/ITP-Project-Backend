package com.itp.importexport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.itp.importexport.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
package com.itp.importexport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.importexport.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

}

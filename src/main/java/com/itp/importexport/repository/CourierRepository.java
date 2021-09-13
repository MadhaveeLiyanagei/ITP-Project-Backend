package com.itp.importexport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.importexport.model.Courier;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long>{

}

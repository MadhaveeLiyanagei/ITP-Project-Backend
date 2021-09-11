package com.itp.importexport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.importexport.model.RequestOrder;

@Repository
public interface RequestOrderRepository extends JpaRepository<RequestOrder, Integer>{

}

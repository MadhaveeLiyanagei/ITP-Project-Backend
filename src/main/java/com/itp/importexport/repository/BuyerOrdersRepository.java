package com.itp.importexport.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itp.importexport.model.BuyerOrders;

@Repository
public interface BuyerOrdersRepository extends JpaRepository<BuyerOrders, Integer> {

}

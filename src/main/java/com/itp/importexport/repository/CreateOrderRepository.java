package com.itp.importexport.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itp.importexport.model.CreateOrder;

	@Repository
		public interface CreateOrderRepository extends JpaRepository<CreateOrder, Integer> {
	
	}

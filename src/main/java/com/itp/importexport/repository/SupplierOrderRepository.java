package com.itp.importexport.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itp.importexport.model.SupplierOrder;

		@Repository
		public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Integer> {
		
		}


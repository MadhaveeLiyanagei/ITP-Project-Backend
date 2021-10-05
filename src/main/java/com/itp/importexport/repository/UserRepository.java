package com.itp.importexport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itp.importexport.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	public User findTopByOrderByUserIdDesc();

}

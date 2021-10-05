package com.itp.importexport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.importexport.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}

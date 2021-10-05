package com.itp.importexport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.importexport.model.AdNotices;

@Repository
public interface AdNoticesRepository extends JpaRepository<AdNotices,Integer>{

}
package com.riwi.vacants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.vacants.Entities.Company;

@Repository
public interface CompanyRepositoy extends JpaRepository <Company, String> {
    
}

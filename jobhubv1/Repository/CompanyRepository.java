package com.example.jobhubv1.Repository;

import com.example.jobhubv1.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository <Company , Integer> {
    Company findCompaniesByCompanyid(Integer id);
}


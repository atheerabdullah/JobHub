package com.example.jobhubv1.Service;


import com.example.jobhubv1.ApiException.ApiException;
import com.example.jobhubv1.Model.Company;
import com.example.jobhubv1.Repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    //CRUD
    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Company company, Integer id) {
        Company updatedCompany= companyRepository.findCompaniesByCompanyid(id);

        if (updatedCompany == null) {
            throw new ApiException("Enter the correct Id");
        }
        updatedCompany.setCompanyname(company.getCompanyname());
        updatedCompany.setEmail(company.getEmail());
        companyRepository.save(updatedCompany);
        return updatedCompany;
    }



    public void deleteCompany(Integer id) {
        Company company = companyRepository.findCompaniesByCompanyid(id);
        if (company == null) {
            throw new ApiException("Company not found");
        }
        companyRepository.delete(company);
    }

}

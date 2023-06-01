package com.example.jobhubv1.Controller;

import com.example.jobhubv1.Model.Company;
import com.example.jobhubv1.Service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor

public class CompanyController {

    private final CompanyService companyService;


    @GetMapping("/getCompanies")
    public ResponseEntity getAllCompany() {
        List<Company> companyList = companyService.getAllCompany();
        return ResponseEntity.status(200).body(companyList);
    }


    @PostMapping("/addCompany")
    public ResponseEntity addCompany(@Valid @RequestBody Company company) {
        companyService.addCompany(company);
        return ResponseEntity.status(200).body("Company added");
    }


    @PutMapping("/updateCompany/{id}")
    public ResponseEntity updateCompany(@Valid @RequestBody Company company, @PathVariable Integer id) {
        companyService.updateCompany(company, id);
        return ResponseEntity.status(200).body("Company Updated");
    }


    @DeleteMapping("/deleteCompany/{id}")
    public ResponseEntity deleteCompany(@PathVariable Integer id) {
        companyService.deleteCompany(id);
        return ResponseEntity.status(200).body("Company deleted");
    }


}




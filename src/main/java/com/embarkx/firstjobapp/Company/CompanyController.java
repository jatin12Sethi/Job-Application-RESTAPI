package com.embarkx.firstjobapp.Company;

import com.embarkx.firstjobapp.Company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public List<Company> findAll() {
        return companyService.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
       companyService.updateCompany(id, company);
        return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);

    }
@PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company != null)
            return new ResponseEntity<>(company, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean deleted = companyService.deleteCompanyById(id);
        if (deleted)
            return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteJob(@PathVariable Long id){
//        boolean deleted = jobService.deleteJobById(id);
//        if (deleted)
//            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


}

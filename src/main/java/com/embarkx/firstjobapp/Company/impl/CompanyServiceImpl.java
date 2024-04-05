package com.embarkx.firstjobapp.Company.impl;

import com.embarkx.firstjobapp.Company.Company;
import com.embarkx.firstjobapp.Company.CompanyRepository;
import com.embarkx.firstjobapp.Company.CompanyService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
  CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
// try {
//        jobRepository.deleteById(id);
//        return true;
//    } catch (Exception e) {
//        return false;
//    }
//}
    @Override
    public boolean deleteCompanyById(Long id) {
    try {
        companyRepository.deleteById(id);
        return true;
    } catch (Exception e) {
        return false;
    }
    }

    @Override
    public boolean updateCompany(Long id, Company updatecompany) {

        Optional<Company> CompanyOptional = companyRepository.findById(id);
        if (CompanyOptional.isPresent()) {
            Company companyToUpdate = CompanyOptional.get();
            companyToUpdate.setName(updatecompany.getName());
            companyToUpdate.setDescription(updatecompany.getDescription());
            companyToUpdate.setJobs(updatecompany.getJobs());
companyRepository.save(companyToUpdate);
            companyRepository.save(companyToUpdate);
            return true;
        } else {
            return false;
        }

    }

//    @Override
//    public boolean updateJob(Long id, Job updatedJob) {
//        Optional<Job> jobOptional = jobRepository.findById(id);
//        if (jobOptional.isPresent()) {
//            Job job = jobOptional.get();
//            job.setTitle(updatedJob.getTitle());
//            job.setDescription(updatedJob.getDescription());
//            job.setMinSalary(updatedJob.getMinSalary());
//            job.setMaxSalary(updatedJob.getMaxSalary());
//            job.setLocation(updatedJob.getLocation());
//            jobRepository.save(job);
//            return true;
//        }
//        return false;
//    }
}

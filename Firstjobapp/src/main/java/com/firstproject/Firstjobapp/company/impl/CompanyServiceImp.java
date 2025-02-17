package com.firstproject.Firstjobapp.company.impl;

import com.firstproject.Firstjobapp.company.Company;
import com.firstproject.Firstjobapp.company.CompanyReposirory;
import com.firstproject.Firstjobapp.company.CompanyService;
import com.firstproject.Firstjobapp.company.Company;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImp implements CompanyService {
    private CompanyReposirory companyReposirory;

    public CompanyServiceImp(@Qualifier("companyRepository") CompanyReposirory companyReposirory) {
        this.companyReposirory = companyReposirory;
    }

    @Override
    public List<Company> findAllComp() {
        return companyReposirory.findAll();
    }

    @Override
    public boolean updateCompany(Long id, Company comp) {
        Optional<Company> jobOptional=companyReposirory.findById(id);
        if(jobOptional.isPresent()){
            Company j=jobOptional.get();
            j.setName(comp.getName());
            j.setDescription(comp.getDescription());
            j.setJobs(comp.getJobs());
           companyReposirory.save(j);
            return true;
    }
        return false;
    }

    @Override
    public boolean addCompany(Company comp) {
        try{
            companyReposirory.save(comp);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteCompany(Long id) {
      try{
          companyReposirory.deleteById(id);
          return true;
      }
      catch(Exception e){
          return false;
        }
    }

    @Override
    public Company getCompanybyId(Long id) {
        return companyReposirory.findById(id).orElse(null);
    }

}

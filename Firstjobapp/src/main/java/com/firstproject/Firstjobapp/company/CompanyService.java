package com.firstproject.Firstjobapp.company;

import org.springframework.stereotype.Service;

import java.util.List;


public interface CompanyService {
    List<Company> findAllComp();
    boolean updateCompany(Long id,Company comp);
    boolean addCompany(Company comp);
    boolean deleteCompany(Long id);
    Company getCompanybyId(Long id);
}

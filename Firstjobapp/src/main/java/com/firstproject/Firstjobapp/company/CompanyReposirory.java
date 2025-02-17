package com.firstproject.Firstjobapp.company;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("companyRepository")

public interface CompanyReposirory extends JpaRepository<Company,Long> {

}

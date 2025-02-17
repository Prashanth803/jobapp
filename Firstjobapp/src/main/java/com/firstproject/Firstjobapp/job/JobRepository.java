package com.firstproject.Firstjobapp.job;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jobRepository")
public interface JobRepository extends JpaRepository<Job,Long> {
}

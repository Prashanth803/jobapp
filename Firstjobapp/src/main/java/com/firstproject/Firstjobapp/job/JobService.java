package com.firstproject.Firstjobapp.job;

import java.util.List;


public interface JobService {
    List<Job> findall();
    void addjob(Job job);
    Job findjob(Long id);

    boolean deleteById(Long id);

    boolean updateById(Long id,Job job);
}

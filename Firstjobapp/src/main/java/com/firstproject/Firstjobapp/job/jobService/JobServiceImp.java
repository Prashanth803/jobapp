package com.firstproject.Firstjobapp.job.jobService;

import com.firstproject.Firstjobapp.job.Job;
import com.firstproject.Firstjobapp.job.JobService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService {
    JpaRepository jpaRepository;

    public JobServiceImp(@Qualifier("jobRepository") JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

//    private Long nextId=1L;
//    private List<Job>jobs=new ArrayList<>();
    @Override
    public List<Job> findall() {
        return jpaRepository.findAll();
    }

    @Override
    public void addjob(Job job) {
        jpaRepository.save(job);
    }

    @Override
    public Job findjob(Long id) {
        return (Job) jpaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
       try{
           jpaRepository.deleteById(id);
           return true;
       }
       catch(Exception e){
           return false;
        }
    }

    @Override
    public boolean updateById(Long id,Job job) {
        Optional<Job>jobOptional=jpaRepository.findById(id);
            if(jobOptional.isPresent()){
                Job j=jobOptional.get();
                j.setTitle(job.getTitle());
                j.setDescription(job.getDescription());
                j.setMinSalary(job.getMinSalary());
                j.setMaxSalary(job.getMaxSalary());
                j.setLocation(job.getLocation());
                jpaRepository.save(j);
                return true;
            }

        return false;
    }


}

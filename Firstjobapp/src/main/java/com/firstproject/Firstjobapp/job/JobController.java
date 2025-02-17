package com.firstproject.Firstjobapp.job;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobservice;

    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findall(){
        return ResponseEntity.ok(jobservice.findall());
    }

    @PostMapping
    public ResponseEntity<String> addjob(@RequestBody Job job){
        try{
        jobservice.addjob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.OK);}
        catch(Exception e){
            return new ResponseEntity<>("Something went wrong"+e,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findjob(@PathVariable Long id){
        Job job=jobservice.findjob(id);
        if(job!=null)return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletejobById(@PathVariable Long id){
        boolean delete=jobservice.deleteById(id);
        if(delete)
            return new ResponseEntity<>("Deleted Sucessfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>updatebyId(@PathVariable Long id, @RequestBody  Job job){
        boolean updated=jobservice.updateById(id,job);
        if(updated)
            return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

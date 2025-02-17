package com.firstproject.Firstjobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.findAllComp(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company comp){
        if(companyService.updateCompany(id,comp))return new ResponseEntity<>("Successfully updated",HttpStatus.OK);
        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company comp){
        if(companyService.addCompany(comp))return new ResponseEntity<>("Successfully added",HttpStatus.CREATED);
        else return new ResponseEntity<>("Unable to save",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletecompany(@PathVariable Long id){
        if(companyService.deleteCompany(id))return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
        return new ResponseEntity<>("NOT found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getcompanybyId(@PathVariable Long id){
        if(companyService.getCompanybyId(id)!=null)return new ResponseEntity<>(companyService.getCompanybyId(id),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

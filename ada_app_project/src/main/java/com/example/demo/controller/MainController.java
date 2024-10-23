package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CompanyResponse;
import com.example.demo.entities.Application;
import com.example.demo.entities.Company;
import com.example.demo.repositories.ApplicationRepository;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.request.CompanyRequest;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	private CompanyRepository companyRepository;
	
    @GetMapping
    public Iterable<Company> list() {
        System.out.println("Fnd all");
        return companyRepository.findAll();
    }

    @PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody CompanyRequest companyRequest, @PathVariable Long id) {
		
		Optional<Company> companyOptional = companyRepository.findById(id);
		
		if(companyOptional.isPresent()) {
			Company foundCompany = companyOptional.get();
			foundCompany.setNameCompany(companyRequest.getNameCompany());
			foundCompany.setDescriptionCompany(companyRequest.getDescriptionCompany());
			companyRepository.save(foundCompany);
			return ResponseEntity.ok(companyOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
    
    @DeleteMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id) {
		companyRepository.deleteById(id);
		return ResponseEntity.ok(new CompanyResponse(String.format("The company with id: %d was dropted", id)));
	}
    
    @Autowired
    private ApplicationRepository applicationRepository;
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CompanyRequest companyRequest) {
    	
    	Optional<Application> applicationOptional = applicationRepository.findById(companyRequest.getAppId());
    	if(applicationOptional.isEmpty()) {
    		ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("The application with id %d wasnt found", companyRequest.getAppId()));
    	}
    	
    	Company company = new Company(companyRequest.getIdCompany(), companyRequest.getCodigoCompany(), companyRequest.getNameCompany(), companyRequest.getDescriptionCompany(),
    			applicationOptional.get());
    	return ResponseEntity.status(HttpStatus.CREATED).body(companyRepository.save(company));
    }
}

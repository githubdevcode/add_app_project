package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.example.demo.entities.Application;
import com.example.demo.entities.Company;
import com.example.demo.entities.Version;
import com.example.demo.repositories.ApplicationRepository;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.repositories.VersionRepository;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.demo.entities"})
public class AdaAppProjectApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdaAppProjectApplication.class, args);
	}

	@Autowired
	private VersionRepository versionRepository;
	@Autowired
	private ApplicationRepository applicationRepository;
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Version version = new Version(1l, "2.0", "the second version");
		versionRepository.save(version);
		Application application = new Application(1l, "ADA", "APP_NAE", "An app for a copany", version);
		applicationRepository.save(application);
		Company company = new Company(1l, "EASS", "limitada", "A compnay for ", application);
		companyRepository.save(company);
	}

}

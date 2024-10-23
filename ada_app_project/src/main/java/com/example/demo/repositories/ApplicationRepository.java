package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Application;
import com.example.demo.entities.Company;

public interface ApplicationRepository extends CrudRepository<Application, Long>{

}

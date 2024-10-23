package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Company;
import com.example.demo.entities.Version;

public interface VersionRepository extends CrudRepository<Version, Long>{

}

package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.response.VersionCompanyResponse2;
import com.example.demo.entities.VersionCompany;

public interface VersionCompanyRepository extends CrudRepository<VersionCompany, Long> {
	
	@Query(nativeQuery = true, value = "select distinct vc.version_company_id as version_company_id, c.id_company as id_company, v.version_id as version_id, v.version as version, "
			+ "	v.version_description as version_description,"
			+ "	vc.version_company_description as version_company_description, c.codigo_company as codigo_company, c.name_company as name_company,"
			+ "  c.description_company as description_company, a.app_code as app_code, a.app_name as app_name,"
			+ "  a.app_description as app_description from version_company as vc"
			+ " inner join version as v"
			+ " on (vc.version_id = v.version_id)"
			+ " inner join company as c"
			+ " on (vc.company_id = c.id_company)"
			+ " inner join application as a"
			+ " on (c.app_id = a.app_id)")
	public List<VersionCompanyResponse2> findAllWithAllDataDistinct();
}

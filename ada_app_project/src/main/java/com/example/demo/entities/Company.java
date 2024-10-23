package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
	@Id
	@Column(name ="id_company")
    private Long idCompany;
	@Column(name = "codigo_company", unique = true)
	private String codigoCompany;
	@Column(name = "name_company")
	private String nameCompany;
	@Column(name = "description_company")
	private String descriptionCompany;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", nullable = true, insertable = true, updatable = true)
	private Application app;
	
	public Company() {
		super();
	}

	public Company(Long idCompany, String codigoCompany, String nameCompany, String descriptionCompany,
			Application app) {
		super();
		this.idCompany = idCompany;
		this.codigoCompany = codigoCompany;
		this.nameCompany = nameCompany;
		this.descriptionCompany = descriptionCompany;
		this.app = app;
	}
	
	public Long getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}
	public String getCodigoCompany() {
		return codigoCompany;
	}
	public void setCodigoCompany(String codigoCompany) {
		this.codigoCompany = codigoCompany;
	}
	public String getNameCompany() {
		return nameCompany;
	}
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	public String getDescriptionCompany() {
		return descriptionCompany;
	}
	public void setDescriptionCompany(String descriptionCompany) {
		this.descriptionCompany = descriptionCompany;
	}
	public Application getApp() {
		return app;
	}
	public void setApp(Application app) {
		this.app = app;
	}
	
    
}

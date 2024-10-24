package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "version_company")
public class VersionCompany {
	@Id
	@Column(name ="version_company_id")
    private Long versionCompanyId;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = true, insertable = true, updatable = true)
	private Company company;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "version_id", nullable = true, insertable = true, updatable = true)
	private Version version;	
	@Column(name ="version_company_description")
	private String versionCompanyDescription;
	public VersionCompany() {
		super();
	}
	public VersionCompany(Long versionCompanyId, Company company, Version version, String versionCompanyDescription) {
		super();
		this.versionCompanyId = versionCompanyId;
		this.company = company;
		this.version = version;
		this.versionCompanyDescription = versionCompanyDescription;
	}
	public Long getVersionCompanyId() {
		return versionCompanyId;
	}
	public void setVersionCompanyId(Long versionCompanyId) {
		this.versionCompanyId = versionCompanyId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	public String getVersionCompanyDescription() {
		return versionCompanyDescription;
	}
	public void setVersionCompanyDescription(String versionCompanyDescription) {
		this.versionCompanyDescription = versionCompanyDescription;
	}
}

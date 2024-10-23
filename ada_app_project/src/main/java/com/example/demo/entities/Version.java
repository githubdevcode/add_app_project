package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "version")
public class Version {
	@Id
	@Column(name = "version_id")
    private Long versionId;
	@Column(name = "version")
	private String version;
	@Column(name = "version_description")
	private String versionDescription;
	public Version() {
		super();
	}
	public Version(Long versionId, String version, String versionDescription) {
		super();
		this.versionId = versionId;
		this.version = version;
		this.versionDescription = versionDescription;
	}
	public Long getVersionId() {
		return versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersionDescription() {
		return versionDescription;
	}
	public void setVersionDescription(String versionDescription) {
		this.versionDescription = versionDescription;
	}
    
}

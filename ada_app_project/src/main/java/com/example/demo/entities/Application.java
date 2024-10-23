package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "application")
public class Application {
	@Id
	@Column(name = "app_id")
    private Long appId;
	@Column(name = "app_code")
	private String appCode;
	@Column(name = "app_name")
	private String appName;
	@Column(name = "app_description")
	private String appDescription;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_id", nullable = true, insertable = true, updatable = true)
	private Version version;
	public Application() {
		super();
	}
	public Application(Long appId, String appCode, String appName, String appDescription, Version version) {
		super();
		this.appId = appId;
		this.appCode = appCode;
		this.appName = appName;
		this.appDescription = appDescription;
		this.version = version;
	}
	public Long getAppId() {
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppDescription() {
		return appDescription;
	}
	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
    
}

package com.example.demo.dto.response;

public class VersionCompanyResponse {
	private Long versionCompanyId;
	private Long idCompany;
	private Long versionId;
	private String version;
	private String versionDescription;
	private String versionCompanyDescription;
	private String codigoCompany;
	private String nameCompany;
	private String descriptionCompany;
	private String appCode;
	private String appName;
	private String appDescription;
	public VersionCompanyResponse() {
		super();
	}
	public VersionCompanyResponse(Long versionCompanyId, Long idCompany, Long versionId, String version,
			String versionDescription, String versionCompanyDescription, String codigoCompany, String nameCompany,
			String descriptionCompany, String appCode, String appName, String appDescription) {
		super();
		this.versionCompanyId = versionCompanyId;
		this.idCompany = idCompany;
		this.versionId = versionId;
		this.version = version;
		this.versionDescription = versionDescription;
		this.versionCompanyDescription = versionCompanyDescription;
		this.codigoCompany = codigoCompany;
		this.nameCompany = nameCompany;
		this.descriptionCompany = descriptionCompany;
		this.appCode = appCode;
		this.appName = appName;
		this.appDescription = appDescription;
	}
	public Long getVersionCompanyId() {
		return versionCompanyId;
	}
	public void setVersionCompanyId(Long versionCompanyId) {
		this.versionCompanyId = versionCompanyId;
	}
	public Long getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
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
	public String getVersionCompanyDescription() {
		return versionCompanyDescription;
	}
	public void setVersionCompanyDescription(String versionCompanyDescription) {
		this.versionCompanyDescription = versionCompanyDescription;
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
}

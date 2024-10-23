package com.example.demo.request;

public class CompanyRequest {
	private long idCompany;
	private String codigoCompany;
	private String nameCompany;
	private String descriptionCompany;
	private long appId;
	public CompanyRequest() {
		super();
	}
	public CompanyRequest(String nameCompany, String descriptionCompany) {
		super();
		this.nameCompany = nameCompany;
		this.descriptionCompany = descriptionCompany;
	}
	public CompanyRequest(long idCompany, String codigoCompany, String nameCompany, String descriptionCompany,
			long appId) {
		super();
		this.idCompany = idCompany;
		this.codigoCompany = codigoCompany;
		this.nameCompany = nameCompany;
		this.descriptionCompany = descriptionCompany;
		this.appId = appId;
	}
	public long getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(long idCompany) {
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
	public long getAppId() {
		return appId;
	}
	public void setAppId(long appId) {
		this.appId = appId;
	}
	
}

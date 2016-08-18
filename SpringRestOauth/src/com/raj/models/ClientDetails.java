package com.raj.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientdetails")
public class ClientDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "appId")
	private String appId;

	@Column(name = "resourceIds")
	private String resourceIds;

	@Column(name = "appSecret")
	private String appSecret;

	@Column(name = "scope")
	private String scope;

	@Column(name = "grantTypes")
	private String grantTypes;

	@Column(name = "redirectUrl")
	private String redirectUrl;

	@Column(name = "authorities")
	private String authorities;

	@Column(name = "access_token_validity")
	private Integer access_token_validity;

	@Column(name = "refresh_token_validity")
	private Integer refresh_token_validity;

	@Column(name = "additionalInformation")
	private String additionalInformation;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getGrantTypes() {
		return grantTypes;
	}

	public void setGrantTypes(String grantTypes) {
		this.grantTypes = grantTypes;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public Integer getAccess_token_validity() {
		return access_token_validity;
	}

	public void setAccess_token_validity(Integer access_token_validity) {
		this.access_token_validity = access_token_validity;
	}

	public Integer getRefresh_token_validity() {
		return refresh_token_validity;
	}

	public void setRefresh_token_validity(Integer refresh_token_validity) {
		this.refresh_token_validity = refresh_token_validity;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

}

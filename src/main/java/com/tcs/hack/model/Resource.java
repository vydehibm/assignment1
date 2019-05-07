package com.tcs.hack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resource {
	@Id
	@Column(name="resource_id")
	private Integer resourceId;
	@Column(name="resource_name")
	private String resourceName;
	public Resource(int resourceId) {
		super();
		this.resourceId = resourceId;
	}
	public Resource() {};
	
	public Resource(Integer resourceId, String resourceName) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
	}
	
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
}

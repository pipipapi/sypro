/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
package sy.model.po;

import com.dap.dao.BasePo;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * tuser 
 */
public class TuserPo extends BasePo {
	private static final long serialVersionUID = -1L;

	private String id;

	/**
	 * 
	 */
	private Date createdatetime;
	
	/**
	 * 
	 */
	private Date modifydatetime;
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private String pwd;

	private Set<TrolePo> roles;
	
    
	public void setCreatedatetime(Date value) {
		this.createdatetime = value;
	}
	
	public Date getCreatedatetime() {
		return this.createdatetime;
	}
	
    
	public void setModifydatetime(Date value) {
		this.modifydatetime = value;
	}
	
	public Date getModifydatetime() {
		return this.modifydatetime;
	}
	
    
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
    
	public void setPwd(String value) {
		this.pwd = value;
	}
	
	public String getPwd() {
		return this.pwd;
	}

	public Set<TrolePo> getRoles() {
		return roles;
	}

	public void setRoles(Set<TrolePo> roles) {
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

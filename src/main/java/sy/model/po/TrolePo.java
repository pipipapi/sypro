/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
package sy.model.po;

import com.dap.dao.BasePo;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * trole 
 */
public class TrolePo extends BasePo {
	private static final long serialVersionUID = -1L;

	private String id;

	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private String remark;
	
	/**
	 * 
	 */
	private Integer seq;
	
	/**
	 * 
	 */
	private String pid;

	//父节点对象
	private TrolePo role;

	private Set<TrolePo> roles;
	
    private Set<TresourcePo> resources;

	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
    
	public void setRemark(String value) {
		this.remark = value;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
    
	public void setSeq(Integer value) {
		this.seq = value;
	}
	
	public Integer getSeq() {
		return this.seq;
	}
	
    
	public void setPid(String value) {
		this.pid = value;
	}
	
	public String getPid() {
		return this.pid;
	}

	public Set<TresourcePo> getResources() {
		return resources;
	}

	public void setResources(Set<TresourcePo> resources) {
		this.resources = resources;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<TrolePo> getRoles() {
		return roles;
	}

	public void setRoles(Set<TrolePo> roles) {
		this.roles = roles;
	}

	public TrolePo getRole() {
		return role;
	}

	public void setRole(TrolePo role) {
		this.role = role;
	}
}

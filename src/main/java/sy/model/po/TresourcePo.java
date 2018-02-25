/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
package sy.model.po;

import com.dap.dao.BasePo;
import java.util.Date;
import java.util.Set;


/**
 * tresource 
 */
public class TresourcePo extends BasePo {
	private static final long serialVersionUID = -1L;

	private String id;

	/**
	 * 
	 */
	private String icon;
	
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
	private String url;
	
	/**
	 * 
	 */
	private String pid;
	
	/**
	 * 
	 */
	private String tresourcetypeId;

	private TresourcePo parent;

	private Set<TresourcetypePo> resourcetypes;
	
    
	public void setIcon(String value) {
		this.icon = value;
	}
	
	public String getIcon() {
		return this.icon;
	}
	
    
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
	
    
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return this.url;
	}
	
    
	public void setPid(String value) {
		this.pid = value;
	}
	
	public String getPid() {
		return this.pid;
	}
	
    
	public void setTresourcetypeId(String value) {
		this.tresourcetypeId = value;
	}
	
	public String getTresourcetypeId() {
		return this.tresourcetypeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TresourcePo getParent() {
		return parent;
	}

	public void setParent(TresourcePo parent) {
		this.parent = parent;
	}

	public Set<TresourcetypePo> getResourcetypes() {
		return resourcetypes;
	}

	public void setResourcetypes(Set<TresourcetypePo> resourcetypes) {
		this.resourcetypes = resourcetypes;
	}
}

/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
package sy.model.po;

import com.dap.dao.BasePo;
import java.util.Date;


/**
 * tuser 
 */
public class TuserPo extends BasePo {
	private static final long serialVersionUID = -1L;
	
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
	
}

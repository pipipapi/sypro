/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
package sy.model;

import com.dap.dao.BasePo;
import java.util.Date;


/**
 * tbug 
 */
public class TbugPo extends BasePo {
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
	private String note;
	
	/**
	 * 
	 */
	private String bugtypeId;
	
    
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
	
    
	public void setNote(String value) {
		this.note = value;
	}
	
	public String getNote() {
		return this.note;
	}
	
    
	public void setBugtypeId(String value) {
		this.bugtypeId = value;
	}
	
	public String getBugtypeId() {
		return this.bugtypeId;
	}
	
}

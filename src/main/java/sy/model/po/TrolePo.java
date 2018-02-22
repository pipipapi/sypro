/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
package sy.model.po;

import com.dap.dao.BasePo;
import java.util.Date;


/**
 * trole 
 */
public class TrolePo extends BasePo {
	private static final long serialVersionUID = -1L;
	
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
	
}

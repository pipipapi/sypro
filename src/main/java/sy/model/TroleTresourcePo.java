/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
package sy.model;

import com.dap.dao.BasePo;
import java.util.Date;


/**
 * trole_tresource 
 */
public class TroleTresourcePo extends BasePo {
	private static final long serialVersionUID = -1L;
	
	/**
	 * 
	 */
	private String troleId;
	
	/**
	 * 
	 */
	private String tresourceId;
	
    
	public void setTroleId(String value) {
		this.troleId = value;
	}
	
	public String getTroleId() {
		return this.troleId;
	}
	
    
	public void setTresourceId(String value) {
		this.tresourceId = value;
	}
	
	public String getTresourceId() {
		return this.tresourceId;
	}
	
}

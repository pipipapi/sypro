/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
package sy.model.po;

import com.dap.dao.BasePo;
import java.util.Date;


/**
 * tuser_trole 
 */
public class TuserTrolePo extends BasePo {
	private static final long serialVersionUID = -1L;
	
	/**
	 * 
	 */
	private String tuserId;
	
	/**
	 * 
	 */
	private String troleId;
	
    
	public void setTuserId(String value) {
		this.tuserId = value;
	}
	
	public String getTuserId() {
		return this.tuserId;
	}
	
    
	public void setTroleId(String value) {
		this.troleId = value;
	}
	
	public String getTroleId() {
		return this.troleId;
	}
	
}

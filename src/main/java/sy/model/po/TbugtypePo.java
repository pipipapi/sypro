/*
 * Copyright(c) 2016 expo.ofweek.com All rights reserved.
 * distributed with this file and available online at
 * http://expo.ofweek.com/
 */
package sy.model.po;

import com.dap.dao.BasePo;
import java.util.Date;


/**
 * tbugtype 
 */
public class TbugtypePo extends BasePo {
	private static final long serialVersionUID = -1L;
	
	/**
	 * 
	 */
	private String name;
	
    
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
}

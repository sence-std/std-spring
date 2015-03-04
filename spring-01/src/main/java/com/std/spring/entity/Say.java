/**
 * @FileName:Say
 * @Package: com.std.spring
 *
 * @author sence
 * @created 3/4/2015 5:44 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.spring.entity;

/**
 *
 * <p>实体类</p>
 *
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author sence
 * @since 1.0
 * @version 1.0
 */
public class Say {

	private String userName;
	private String sayContent;

	public Say () {

	}

	public String getUserName () {
		return userName;
	}

	public void setUserName (String userName) {
		this.userName = userName;
	}

	public String getSayContent () {
		return sayContent;
	}

	public void setSayContent (String sayContent) {
		this.sayContent = sayContent;
	}

	public String sayHello(){
		return "Hello "+this.getUserName()+","+(this.getSayContent()==null?"":this.getSayContent());
	}
}

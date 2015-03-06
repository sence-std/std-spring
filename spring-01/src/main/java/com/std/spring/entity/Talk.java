/**
 * @FileName:Talk
 * @Package: com.std.spring.entity
 *
 * @author sence
 * @created 3/6/2015 9:48 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.spring.entity;

import java.util.List;

/**
 *
 * <p>talk 实体类</p>
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
public class Talk {

	/**say对象*/
	private List<Say> sayList;

	private String name;

	/**talk对象*/
	private List<Talk> talk;


	public List<Say> getSayList () {
		return sayList;
	}

	public void setSayList (List<Say> sayList) {
		this.sayList = sayList;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public List<Talk> getTalk () {
		return talk;
	}

	public void setTalk (List<Talk> talk) {
		this.talk = talk;
	}
}

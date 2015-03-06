/**
 * @FileName:SayNamespaceHandler
 * @Package: com.std.spring
 *
 * @author sence
 * @created 3/4/2015 5:28 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.spring.handler;

import com.std.spring.multiple.TalkBeanDefinitionParser;
import com.std.spring.single.SayBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 *
 * <p>SAY标签命名空间解析</p>
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
public class StdNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init () {
		registerBeanDefinitionParser("say", new SayBeanDefinitionParser());
		registerBeanDefinitionParser("talk",new TalkBeanDefinitionParser());
	}
}

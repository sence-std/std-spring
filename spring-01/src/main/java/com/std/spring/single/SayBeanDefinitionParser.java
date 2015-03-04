/**
 * @FileName:SayBeanDefinitionParser
 * @Package: com.std.spring
 *
 * @author sence
 * @created 3/4/2015 5:31 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.spring.single;

import com.std.spring.entity.Say;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 *
 * <p>标签解析器</p>
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
public class SayBeanDefinitionParser extends AbstractSingleBeanDefinitionParser{

	@Override
	public Class<?> getBeanClass (Element element) {
		return Say.class;
	}

	@Override
	public void doParse (Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		String name=element.getAttribute("name");
		builder.addPropertyValue("userName", name);
		String word = element.getAttribute("word");
		if(StringUtils.hasText(word)) {
			builder.addPropertyValue("sayContent",word);
		}
	}
}

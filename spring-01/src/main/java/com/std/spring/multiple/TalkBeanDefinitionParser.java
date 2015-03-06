/**
 * @FileName:TalkBeanDefinitionParser
 * @Package: com.std.spring.multiple
 *
 * @author sence
 * @created 3/6/2015 9:37 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.spring.multiple;

import com.std.spring.entity.Say;
import com.std.spring.entity.Talk;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import java.util.List;

/**
 *
 * <p>bean 解析</p>
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
public class TalkBeanDefinitionParser extends AbstractBeanDefinitionParser{

	@Override
	public AbstractBeanDefinition parseInternal (Element element, ParserContext parserContext) {
		AbstractBeanDefinition  talkBeanDefinition = parseTalk(element);
		return talkBeanDefinition;
	}

	private AbstractBeanDefinition  parseTalk (Element element) {
		BeanDefinitionBuilder builder =  BeanDefinitionBuilder.rootBeanDefinition(Talk.class);
		String name = element.getAttribute("name");
		List<Element> sayElement = DomUtils.getChildElementsByTagName(element, "say");
		List<Element> childElements = DomUtils.getChildElementsByTagName(element, "talk");
		builder.addPropertyValue("sayList",parseSays(sayElement));
		builder.addPropertyValue("talk", parseChildTalks(childElements));
		builder.addPropertyValue("name",name);
		return builder.getBeanDefinition();
	}

	private ManagedList<BeanDefinition> parseSays (List<Element> sayElement) {
		ManagedList<BeanDefinition> childrenSays = new ManagedList<>(sayElement.size());
		for (Element element : sayElement) {
			childrenSays.add(parseSay(element));
		}
		return childrenSays;
	}

	private BeanDefinition parseSay (Element element) {
		BeanDefinitionBuilder builder =  BeanDefinitionBuilder.rootBeanDefinition(Say.class);
		String name=element.getAttribute("name");
		builder.addPropertyValue("userName", name);
		String word = element.getAttribute("word");
		if(StringUtils.hasText(word)) {
			builder.addPropertyValue("sayContent",word);
		}
		return builder.getBeanDefinition();
	}
	private ManagedList<BeanDefinition> parseChildTalks (List<Element> childTalkElements) {
		ManagedList<BeanDefinition> childrens = new ManagedList<>(childTalkElements.size());
		for (Element element : childTalkElements) {
			childrens.add(parseTalk(element));
		}
		return childrens;
	}

}

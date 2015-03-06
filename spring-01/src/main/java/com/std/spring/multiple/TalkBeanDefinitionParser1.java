/**
 * @FileName:TalkBeanDefinitionParser1
 * @Package: com.std.spring.multiple
 *
 * @author sence
 * @created 3/6/2015 1:36 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.spring.multiple;

import com.std.spring.entity.Say;
import com.std.spring.entity.Talk;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import java.util.List;

/**
 *
 * <p>直接实现BeanDifinitionParser</p>
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
public class TalkBeanDefinitionParser1 implements BeanDefinitionParser{

	/**
	 * Parse the specified {@link org.w3c.dom.Element} and register the resulting
	 * {@link org.springframework.beans.factory.config.BeanDefinition BeanDefinition(s)} with the
	 * {@link org.springframework.beans.factory.xml.ParserContext#getRegistry() BeanDefinitionRegistry}
	 * embedded in the supplied {@link org.springframework.beans.factory.xml.ParserContext}.
	 * <p>Implementations must return the primary {@link org.springframework.beans.factory.config.BeanDefinition} that results
	 * from the parse if they will ever be used in a nested fashion (for example as
	 * an inner tag in a {@code <property/>} tag). Implementations may return
	 * {@code null} if they will <strong>not</strong> be used in a nested fashion.
	 * @param element the element that is to be parsed into one or more {@link org.springframework.beans.factory.config.BeanDefinition BeanDefinitions}
	 * @param parserContext the object encapsulating the current state of the parsing process;
	 * provides access to a {@link org.springframework.beans.factory.support.BeanDefinitionRegistry}
	 * @return the primary {@link org.springframework.beans.factory.config.BeanDefinition}
	 */
	@Override
	public BeanDefinition parse (Element element, ParserContext parserContext) {
		BeanDefinition  talkBeanDefinition = parseTalk(element);
		//注册bean
		String beanName = element.getAttribute("id");
		String beanAlias = element.getAttribute("name");
		parserContext.getRegistry().registerBeanDefinition(beanName,talkBeanDefinition);
		parserContext.getRegistry().registerAlias(beanName,beanAlias);
		return talkBeanDefinition;
	}


	private BeanDefinition parseTalk (Element element) {
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

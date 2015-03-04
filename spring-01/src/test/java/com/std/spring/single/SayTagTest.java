/**
 * @FileName:SayTagTest
 * @Package: com.std.spring.single
 *
 * @author sence
 * @created 3/4/2015 6:01 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.spring.single;

import com.std.spring.entity.Say;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 *
 * <p>say标签解析单元测试</p>
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class SayTagTest {

	@Resource(name="sayHello")
	private Say say;

	@Test
	public void testSay(){
		Assert.assertNotNull(say);
		System.out.println(say.sayHello());
		Assert.assertEquals("Hello sence,hello",say.sayHello());
	}

}

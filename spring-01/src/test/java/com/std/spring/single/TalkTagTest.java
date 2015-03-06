/**
 * @FileName:TalkTagTest
 * @Package: com.std.spring.single
 *
 * @author sence
 * @created 3/6/2015 9:48 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.spring.single;

import com.std.spring.entity.Talk;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 *
 * <p>talk标签测试</p>
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
public class TalkTagTest {


	@Resource(name="talk")
	private Talk talk;

	@Test
	public void test(){
		Assert.assertNotNull(talk);
		Assert.assertEquals(talk.getTalk().size(),1);
		Assert.assertEquals(talk.getTalk().get(0).getName(),"talk-1");
		Assert.assertEquals(talk.getTalk().get(0).getSayList().size(),2);
		Assert.assertEquals(talk.getTalk().get(0).getTalk().size(),2);
	}

}

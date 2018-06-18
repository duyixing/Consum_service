package com.guanqi.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guanqi.common.KafkaConsumer_self;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/config/*.xml" })
public class TestRecMsg {

	@Test
	public void testRecMsg() {
		int hashCode = Math.abs("ttt".hashCode());
		int partition = hashCode % 50;
		System.out.printf("partition = %d%n",partition);

		KafkaConsumer_self aa = new KafkaConsumer_self("test",
				Arrays.asList("dulj"));
		try {
			aa.testGetMsg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

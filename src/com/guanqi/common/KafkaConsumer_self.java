package com.guanqi.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.guanqi.dto.GrPolicyUnitDto;

public class KafkaConsumer_self {
	private final KafkaConsumer<String, String> consumer;
	private final List<String> topics;

	public KafkaConsumer_self(String groupId, List<String> topics) {
		this.topics = topics;
		Properties props = new Properties();
		props.put("bootstrap.servers",
				"192.168.134.22:9092,192.168.134.22:9092,192.168.134.22:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		this.consumer = new KafkaConsumer<>(props);
	}

	public void testGetMsg() {
		consumer.subscribe(topics);
		// 192.168.134.23:2181,192.168.134.24:2181

		while (true) {
			try {
				ConsumerRecords<String, String> records = consumer.poll(40000000);
				for (ConsumerRecord<String, String> record : records) {
					Map<String, Object> data = new HashMap<>();
					String msg = record.value();
					System.out.printf("partitionid = %d, key = %s, value = %s%n",
							record.partition(), record.key(), record.value());
					System.out.println(3/0);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
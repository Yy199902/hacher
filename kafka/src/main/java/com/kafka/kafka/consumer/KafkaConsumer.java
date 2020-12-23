package com.kafka.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaConsumer {
     // 消费监听
//    @KafkaListener(topics = {"topic1"})
//    public void onMessage1(ConsumerRecord<?, ?> record){
//        // 消费的哪个topic、partition的消息,打印出消息内容
//        System.out.println("简单消费："+record.topic()+"-分区:"+record.partition()+"-"+record.value());
//    }


    @KafkaListener(topics = "topic1")
    public void onMessage3(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) {

        System.out.println(">>>批量消费一次，records.size()="+records.size());

        if (!records.isEmpty()){
            for (ConsumerRecord<?, ?> record : records) {
                System.out.println("简单消费："+record.topic()+"-分区:"+record.partition()+"-"+record.value());
            }
        }
        ack.acknowledge();
    }
}

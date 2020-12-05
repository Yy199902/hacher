package com.pay.pay.consumer;

import com.pay.pay.dao.PayDao;
import com.pay.pay.entry.Event;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import sun.plugin2.message.Message;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Session;

@Component
public class ConsumerQueue {

    @Autowired
    private PayDao payDao;

    @JmsListener(destination = "ActiveMQQueue",containerFactory = "jmsListenerContainerFactory")
    public void receive(TextMessage textMessage, Session session) throws JMSException {
        try {
            System.out.println("收到的消息："+textMessage.getText());
            String content = textMessage.getText();
            if ("".equals(content)){
                Event o = (Event) JSONObject.toBean(JSONObject.fromObject(content), Event.class);
                payDao.add(o);
            }
            textMessage.acknowledge();
//            session.recover();
        } catch (JMSException e) {
            System.out.println(e.getMessage());
            session.recover();
        }

    }

    /**
     * 补偿 处理（人工，脚本）。自己根据自己情况。
     * @param text
     */
    @JmsListener(destination = "ActiveMQ.DLQ.Queue.ActiveMQQueue")
    public void receive2(String text){
        System.out.println("死信队列:"+text);
    }
}

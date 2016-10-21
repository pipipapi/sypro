package liutf.RocketMQ;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * RocketMQ 生产者
 *
 * @author ltf
 * @create 2016-10-19 下午 3:38
 **/
public class Producer {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
        producer.setNamesrvAddr("192.168.98.134:9876");
        try {
            producer.start();

            for (int i = 0; i < 10; i++) {
                Message msg = new Message("MyMQTest",
                        "push",
                        "1",
                        (System.currentTimeMillis() + "~555").getBytes());

                SendResult result = producer.send(msg);
                System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}

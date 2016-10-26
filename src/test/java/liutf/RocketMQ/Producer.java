package liutf.RocketMQ;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;
import com.alibaba.rocketmq.common.message.Message;

/**
 * RocketMQ 生产者
 *
 * @author ltf
 * @create 2016-10-19 下午 3:38
 **/
public class Producer {

    private static final String NAMESRV_ADDR = "192.168.98.232:9876";
    private static final String PRODUCER_GROUP = "Producer";

    public static void main(String[] args) {
        defaultMQProducerTest();

    }

    public static void defaultMQProducerTest() {
        DefaultMQProducer producer = new DefaultMQProducer(PRODUCER_GROUP);
        producer.setNamesrvAddr(NAMESRV_ADDR);
        try {
            producer.start();

            for (int i = 0; i < 10; i++) {
                String tag = "B";
                Message msg = new Message("MyMQTest",
                        tag,
                        "1",
                        (System.currentTimeMillis() + "~" + i + "~" + tag).getBytes());

                SendResult result = producer.send(msg);
                System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }


    public static void transactionMQProducerTest() {
        TransactionMQProducer producer = new TransactionMQProducer(PRODUCER_GROUP);
        producer.setNamesrvAddr(NAMESRV_ADDR);
        try {
            producer.start();

            Message msg = new Message("MyMQTest",
                    "push",
                    "1",
                    (System.currentTimeMillis() + "~555").getBytes());
            SendResult result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}

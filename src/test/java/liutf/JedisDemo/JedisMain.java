package liutf.JedisDemo;

import liutf.JedisDemo.bean1.JavaBean;
import org.springframework.util.SerializationUtils;

/**
 * Created by ltf on 2016-06-14.
 */
public class JedisMain {
    public static void main(String[] args) {
//        JedisDemo.setJedis("key1", "value1");
//        System.out.println(JedisDemo.getJedis("key1"));

        JavaBean javaBean = new JavaBean();
        javaBean.setName("name1");
        javaBean.setAge(11);
        JedisDemo.setJedisObj("bean",javaBean);
        byte[] value = JedisDemo.getJedisObj("bean");

        Object result = SerializationUtils.deserialize(value);
        //liutf.JedisDemo.bean2.JavaBean

    }
}

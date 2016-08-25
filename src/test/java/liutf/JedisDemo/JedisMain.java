package liutf.JedisDemo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.SerializationUtils;

/**
 * Created by ltf on 2016-06-14.
 */
public class JedisMain {
    public static void main(String[] args) {
//        JedisDemo.setJedis("key1", "value1");
//        System.out.println(JedisDemo.getJedis("key1"));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "value1");
        jsonObject.put("key2", "value2");

        JedisDemo.setJedisObj("jsonObject",jsonObject);


        byte[] bytes = JedisDemo.getJedisObj("jsonObject");
        JSONObject jsonObject1 = (JSONObject) SerializationUtils.deserialize(bytes);
        System.out.println(jsonObject1.toString());

        //TODO 尝试用这种方式解析

    }
}

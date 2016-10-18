package liutf.JedisDemo;

/**
 * Created by ltf on 2016-06-14.
 */
public class JedisMain {
    public static void main(String[] args) {
//        JedisDemo.setJedis("key1", "value1");
//        System.out.println(JedisDemo.getJedis("key1"));

        //JSONObject jsonObject = new JSONObject();
        //jsonObject.put("key1", "value1");
        //jsonObject.put("key2", "value2");
        //
        //JedisDemo.setJedisObj("jsonObject",jsonObject);


        //byte[] bytes = JedisDemo.getJedisObj("jsonObject");
        //JSONObject jsonObject1 = (JSONObject) SerializationUtils.deserialize(bytes);
        //System.out.println(jsonObject1.toString());


        //JedisDemo.hset("index:0_pushToken", "510", "test", -1);
        //Object object = (Object) JedisDemo.hget("index:0_pushToken", "510");
        //System.out.println(object + "");

        //MsgPushToken pushToken = (MsgPushToken) JedisDemo.hget("index:0_pushToken", "510");
        //
        //Map<String,Object> returnMap = new HashMap<String,Object>();

        //if(pushToken == null || pushToken.getPushToken().equals("")){
        //    returnMap.put("orderPush", true);
        //    returnMap.put("openPush", true);
        //}else{
        //    returnMap.put("orderPush", pushToken.isOrderPush());
        //    returnMap.put("openPush", pushToken.isOpenPush());
        //}
        //System.out.println(returnMap.toString());


        //Object pushToken = (Object) JedisDemo.hget("index:0_pushToken", "510");
        //System.out.println(pushToken.toString());


        //MsgPushToken mpt = new MsgPushToken();
        //mpt.setCustomerId("123456");
        //JedisDemo.hset("index:0_pushToken", "1133", mpt, -1);


        //MsgPushToken pushToken = (MsgPushToken) JedisDemo.hget("index:0_pushToken", "2");
        //System.out.println(pushToken.getCustomerId());




        //TODO 尝试用这种方式解析


        //String jsonStr = "{\"logisticID\":\"BHJJ113355\",\"reason\":null,\"result\":\"true\",\"resultCode\":\"1000\",\"uniquerRequestNumber\":\"7400679405340457\"}";
        //JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        //
        //new Jsonresult



        String hand2 = "3.0.2_862607034367432_AiByEaGlePegIon_001";
        String version = "3.0.2";
        String uuid = "62607034367432";
        System.out.println();


    }
}

package liutf.SerializationDemo;

/**
 * Created by liutengfei on 16/6/14.
 */
public class RedisMain {
    //public static void main(String[] args) {
    //    RedisUtils.setRedisObj();
    //}

    public static void main(String[] args) {
        //Map<String,String> map = new HashMap<>();
        //map.put("key1","value1");
        //System.out.println(map.get("key1"));
        //map.put("key1","value2");
        //System.out.println(map.get("key1"));
        int i = 0;
        while (i<3){
            i++;
            if(i==2){
                continue;
            }

            System.out.println(i);
        }
    }

}

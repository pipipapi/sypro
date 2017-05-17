package liutf.SerializationDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liutengfei on 16/6/14.
 */
public class RedisMain {
    //public static void main(String[] args) {
    //    RedisUtils.setRedisObj();
    //}

    public static void main(String[] args) {
        //Bean1 bean1 = new Bean1();
        //bean1.setAge(10);
        //bean1.setName("name");
        ////bean1.setFlag(true);
        //
        //RedisUtils.setRedisObj("key_bean1",bean1);

        //Object obj = RedisUtils.getRedisObj("key_bean1");
        //Bean1 bean11 = (Bean1)obj;
        //System.out.println(bean11.toString());

        //String key = "testSet";
        //
        //String[] strArray = new String[10000];
        //for (int i = 0; i < 10000; i++) {
        //    strArray[i] = "str_" + i;
        //}
        //
        ////RedisSetUtils.sadd(key, strArray);
        //
        //boolean result = RedisSetUtils.sismember(key, "str_1");
        //
        //
        ////Long result = RedisSetUtils.srem(key,"str_1");
        //
        //System.out.println("result-->" + result);


        String key = "testSortSet";
        String[] strArray = new String[10000];
        Map<String, Double> scoreMembers = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            strArray[i] = "str_" + i;
            scoreMembers.put("str_" + i, Double.parseDouble((i + 555) + ""));
        }

        //Long result = RedisSortSetUtils.zadd(key, scoreMembers);

        //Set<Tuple> result = RedisSortSetUtils.zrevrangeWithScores(key, 0, 9);
        //for (Tuple tu : result) {
        //    System.out.println(tu.getElement() + "--" + tu.getScore());
        //}

        Double result = RedisSortSetUtils.zincrby(key, -2, "str_-1");


        System.out.println("result-->" + result.toString());
    }

}

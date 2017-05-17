package liutf.SerializationDemo;

import redis.clients.jedis.Jedis;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2017-04-12 下午 3:16
 **/
public class RedisSetUtils {

    public static Long sadd(String var1, String... var2) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost", 6379);
            return jedis.sadd(var1, var2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public static Long srem(String var1, String... var2) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost", 6379);
            return jedis.srem(var1, var2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public static Boolean sismember(String var1, String var2) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost", 6379);
            return jedis.sismember(var1, var2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

}

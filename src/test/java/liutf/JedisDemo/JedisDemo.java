package liutf.JedisDemo;


import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;

/**
 * Created by ltf on 2016-06-14.
 */
public class JedisDemo {

    public static void setJedis(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("192.168.98.143", 6379);
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public static String getJedis(String key) {
        String result = "";
        Jedis jedis = null;
        try {
            jedis = new Jedis("192.168.98.143", 6379);
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }


    public static void setJedisObj(String key, Object value) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("192.168.98.143", 6379);
            jedis.set(key.getBytes(), SerializationUtils.serialize(value));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public static byte[] getJedisObj(String key) {
        byte[] result = null;
        Jedis jedis = null;
        try {
            jedis = new Jedis("192.168.98.143", 6379);
            result = jedis.get(key.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

}

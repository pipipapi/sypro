package liutf.JedisDemo;


import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

/**
 * Created by ltf on 2016-06-14.
 */
public class JedisDemo {

    public static void setJedis(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("123.59.36.200", 6379);
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
            jedis = new Jedis("123.59.36.200", 6379);
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
            jedis = new Jedis("123.59.36.200", 6379);
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
            jedis = new Jedis("192.168.97.24", 6379);
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

    public static Object hget(String key, String field) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("192.168.97.24", 6379);
            byte[] obj = jedis.hget(key.getBytes(), field.getBytes());
            if (obj == null)
                return null;
            return SerializeUtil.unserialize(obj);
        } catch (JedisException e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }


    public static boolean hset(String key, String field, Object value, int seconds) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("192.168.97.24", 6379);
            jedis.hset(key.getBytes(), field.getBytes(), SerializeUtil.serialize(value));
            if (seconds > 0) {
                jedis.expire(key.getBytes(), seconds);
            }
            return true;
        } catch (JedisException e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

}

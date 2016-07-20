package liutf.SerializationDemo;

import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;

/**
 * Created by liutengfei on 16/6/14.
 */
public class RedisUtils {

    public static void setRedisObj(String key, Object value) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("192.168.0.108", 6379);
            jedis.set(key.getBytes(), SerializationUtils.serialize(value));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public static byte[] getRedisObj(String key){
        Jedis jedis = null;
        try {
            jedis = new Jedis("192.168.0.108", 6379);
            return jedis.get(key.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return null;
    }
}

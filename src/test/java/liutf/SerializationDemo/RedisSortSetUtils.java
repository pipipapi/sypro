package liutf.SerializationDemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Map;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2017-04-12 下午 3:33
 **/
public class RedisSortSetUtils {

    public static Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost", 6379);
            return jedis.zrevrangeWithScores(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }


    public static Long zadd(String key, Map<String, Double> scoreMembers) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost", 6379);
            return jedis.zadd(key, scoreMembers);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }


    public static Long zrem(String key, String... members) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost", 6379);
            return jedis.zrem(key, members);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public static Double zincrby(String key, double score, String member) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost", 6379);
            return jedis.zincrby(key, score, member);
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

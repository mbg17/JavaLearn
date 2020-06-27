package Redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class RedisTest {
    /**
     * jedis 设置获取字符串
     */
    @Test
    public void test(){
        Jedis jedis = new Jedis("localhost",6379);
        String root = jedis.auth("root");
        jedis.set("username","hehe");
        String string = jedis.get("username");
        System.out.println(string);
    }

    /**
     * jedis 设置获取hash列表
     */
    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);
        String root = jedis.auth("root");
        jedis.hset("hash","hehe","20");
        String hash = jedis.hget("hash","hehe");
        System.out.println(hash);
    }

    /**
     * jedis 设置获取list列表
     */
    @Test
    public void test2(){
        Jedis jedis = new Jedis("localhost",6379);
        String root = jedis.auth("root");
        jedis.lpush("list","a","b","c");
        jedis.rpush("list","e","r","g");
        List<String> list = jedis.lrange("list",0,-1);
        System.out.println(list);
    }

    /**
     * jedis 设置获取set集合
     */
    @Test
    public void test3(){
        Jedis jedis = new Jedis("localhost",6379);
        String root = jedis.auth("root");
        jedis.sadd("set","a","b","c");
        Set<String> set = jedis.smembers("set");
        System.out.println(set);
    }

    /**
     * jedis 设置获取sortedset集合
     */
    @Test
    public void test4(){
        Jedis jedis = new Jedis("localhost",6379);
        String root = jedis.auth("root");
        jedis.zadd("sortedset",10,"luyuan");
        jedis.zadd("sortedset",20,"xixi");
        Set<String> sortedset = jedis.zrange("sortedset", 0, -1);
        System.out.println(sortedset);
    }

    /**
     * 使用Jedis工具类设置获取值
     */
    @Test
    public void test5(){
        Jedis jedis = JedisPoolUtils.getJedis();
        String root = jedis.auth("root");
        jedis.zadd("sortedset",10,"luyuan");
        jedis.zadd("sortedset",20,"xixi");
        Set<String> sortedset = jedis.zrange("sortedset", 0, -1);
        System.out.println(sortedset);
        JedisPoolUtils.close(jedis);
    }
}

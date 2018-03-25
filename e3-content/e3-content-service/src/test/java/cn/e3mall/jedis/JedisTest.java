package cn.e3mall.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	@Test
	public void testJedis() throws Exception{
		
		Jedis jedis = new Jedis("192.168.25.133",6379);
		
		jedis.set("test123", "test redis");
		String string = jedis.get("test123");
		System.out.println(string);
		
		jedis.close();
	}
	
	@Test
	public void testJedisPool() throws Exception{
	//连接池
	JedisPool jedisPool = new JedisPool("192.168.25.133",6379);
	//创建一个连接
	Jedis jedis = jedisPool.getResource();
	String string = jedis.get("test123");
	System.out.println(string);
	jedis.close();
	//关闭连接池
	jedisPool.close();
	}
	
}
	

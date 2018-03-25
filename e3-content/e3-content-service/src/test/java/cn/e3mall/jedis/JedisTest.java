package cn.e3mall.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {

	@Test
	public void testJedis() throws Exception{
		
		Jedis jedis = new Jedis("192.168.25.133",6379);
		
		jedis.set("test123", "test redis");
		String string = jedis.get("test123");
		System.out.println(string);
		
		jedis.close();
	}
}

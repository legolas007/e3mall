package cn.e3mall.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
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
	
	/**
	 * JedisCluster连接集群
	 * @throws Exception
	 */
	@Test
	public void testJedisCluster() throws Exception{
		//创建一个JedisCluster，参数nodes是set类型，set包含若干HostAndPort对象
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.25.133", 7001));
		nodes.add(new HostAndPort("192.168.25.133", 7002));
		nodes.add(new HostAndPort("192.168.25.133", 7003));
		nodes.add(new HostAndPort("192.168.25.133", 7004));
		nodes.add(new HostAndPort("192.168.25.133", 7005));
		nodes.add(new HostAndPort("192.168.25.133", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		//直接使用jedisCluster操作redis
		jedisCluster.set("test", "test JedisCluster redis-cluster");
		String string = jedisCluster.get("test");
		System.out.println(string);
		//close
		jedisCluster.close();
	}
	
}
	

package com.chinalife.redis.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPool;


public class CopyOfTestRedis {
	
	 private static BinaryJedisCluster jc;
	
	public static void main(String[] args) throws IOException{
		
	
	
	Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
	jedisClusterNodes.add(new HostAndPort("10.253.2.7", 7002));
	GenericObjectPoolConfig config = new GenericObjectPoolConfig();
	 config.setMaxTotal(500);
     //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
     config.setMaxIdle(5);
     //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
     config.setMaxWaitMillis(1000 * 100);
     //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
     config.setTestOnBorrow(true);
	 jc = new BinaryJedisCluster(jedisClusterNodes);  
	 System.out.println("test :"+new String(jc.get("qqqq".getBytes())));
	 
	 //jc.set("AAAA".getBytes(), "1111".getBytes());
	 
	 //System.out.println("hello : "+jc);
	 Map<String, JedisPool> clusterNodes = jc.getClusterNodes();
	 System.out.println("MAP :"+clusterNodes);
	 jc.close();
	 /*jedisClusterNodes.clear();
	 jedisClusterNodes.add(new HostAndPort("10.253.2.7", 7002));
	 jc = new BinaryJedisCluster(jedisClusterNodes); 
	 System.out.println("hello : "+jc.get("AAAA".getBytes()));
	 jc.close();*/
				
//		  System.out.println("connection is OK==========>: "+jedis.ping());
//		  
//		  String value = jedis.get("aaaa");
//		  System.out.println("aaaa :"+value);
		
		 
		  
		/*  Jedis jedis = new Jedis("10.253.2.7",6379);
		  jedis.set("hello ", "AAAA");
		  System.out.println("hello : "+jedis.get("hello"));
		  jedis.close();*/

	}

}

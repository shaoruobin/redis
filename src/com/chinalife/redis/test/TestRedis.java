package com.chinalife.redis.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPool;


public class TestRedis {
	
	 private static BinaryJedisCluster jc;
	
	public static void main(String[] args) throws IOException{
		
	
	
	Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
	jedisClusterNodes.add(new HostAndPort("10.253.2.7", 7001));
	
	 jc = new BinaryJedisCluster(jedisClusterNodes);  
	 
	 
	 //jc.set("AAAA".getBytes(), "1111".getBytes());
	 
	 //System.out.println("hello : "+jc);
	 Map<String, JedisPool> clusterNodes = jc.getClusterNodes();
	 System.out.println("MAP :"+clusterNodes);
	 jc.set("qqqq".getBytes(), "AAAA".getBytes());
	 System.out.println("test :"+jc.get("qqqq".getBytes()));
	 jc.close();
	 jedisClusterNodes.clear();
	 jedisClusterNodes.add(new HostAndPort("10.253.2.7", 7002));
	 jc = new BinaryJedisCluster(jedisClusterNodes); 
	 System.out.println("hello : "+jc.get("qqqq".getBytes()));
	 System.out.println("hello : "+new String(jc.get("qqqq".getBytes())));
	 
	 jc.close();
				
//		  System.out.println("connection is OK==========>: "+jedis.ping());
//		  
//		  String value = jedis.get("aaaa");
//		  System.out.println("aaaa :"+value);
		
		 
		  
		/* Jedis jedis = new Jedis("10.253.2.7",7002);
		  jedis.set("hello ", "AAAA");
		  System.out.println("hello : "+jedis.get("hello"));
		  System.out.println("hell : "+jedis.get("hell"));
		  jedis.close();*/

	}

}

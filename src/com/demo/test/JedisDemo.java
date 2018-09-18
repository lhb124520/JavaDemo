package com.demo.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Jedis;

public class JedisDemo {
	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
		StringTest(jedis);
		ListTest(jedis);
		KeysTest(jedis);
		JedisPool();
	}

	/**
	 * Redis Java String(字符串) 实例
	 */
	public static void StringTest(Jedis jedis) {
		System.out.println("-----------Redis Java String(字符串) 实例------------------");
		jedis.set("runoobkey", "www.runoob.com");
		// 获取存储的数据并输出
		System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
	}

	/**
	 * Redis Java List(列表) 实例
	 */
	public static void ListTest(Jedis jedis) {
		System.out.println("-----------Redis Java List(列表) 实例------------------");
		// 存储数据到列表中
		jedis.lpush("site-list", "Runoob1");
		jedis.lpush("site-list", "Google2");
		jedis.lpush("site-list", "Taobao3");
		// 获取存储的数据并输出
		List<String> list = jedis.lrange("site-list", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("列表项为: " + list.get(i));
		}
	}

	/**
	 * Redis Java Keys 实例
	 */
	public static void KeysTest(Jedis jedis) {
		System.out.println("-----------Redis Java Keys 实例------------------");
		// 获取数据并输出
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
	}

	/**
	 * 测试JedisPool连接池
	 */
	public static void JedisPool() {
		System.out.println("-----------测试JedisPool连接池------------------");
		JedisPool jedisPool = JedisUtil.getJedisPoolInstance();		
		Jedis jedis2 = null;
		try {
          jedis2=jedisPool.getResource();
          jedis2.set("k1", "keys value");
          System.out.println("redis 存储的字符串为: " + jedis2.get("k1"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JedisUtil.release(jedisPool, jedis2);
		}
	}
}

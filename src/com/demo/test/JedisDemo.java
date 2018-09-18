package com.demo.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Jedis;

public class JedisDemo {
	public static void main(String[] args) {
		// ���ӱ��ص� Redis ����
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println("���ӳɹ�");
		// �鿴�����Ƿ�����
		System.out.println("������������: " + jedis.ping());
		StringTest(jedis);
		ListTest(jedis);
		KeysTest(jedis);
		JedisPool();
	}

	/**
	 * Redis Java String(�ַ���) ʵ��
	 */
	public static void StringTest(Jedis jedis) {
		System.out.println("-----------Redis Java String(�ַ���) ʵ��------------------");
		jedis.set("runoobkey", "www.runoob.com");
		// ��ȡ�洢�����ݲ����
		System.out.println("redis �洢���ַ���Ϊ: " + jedis.get("runoobkey"));
	}

	/**
	 * Redis Java List(�б�) ʵ��
	 */
	public static void ListTest(Jedis jedis) {
		System.out.println("-----------Redis Java List(�б�) ʵ��------------------");
		// �洢���ݵ��б���
		jedis.lpush("site-list", "Runoob1");
		jedis.lpush("site-list", "Google2");
		jedis.lpush("site-list", "Taobao3");
		// ��ȡ�洢�����ݲ����
		List<String> list = jedis.lrange("site-list", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("�б���Ϊ: " + list.get(i));
		}
	}

	/**
	 * Redis Java Keys ʵ��
	 */
	public static void KeysTest(Jedis jedis) {
		System.out.println("-----------Redis Java Keys ʵ��------------------");
		// ��ȡ���ݲ����
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
	}

	/**
	 * ����JedisPool���ӳ�
	 */
	public static void JedisPool() {
		System.out.println("-----------����JedisPool���ӳ�------------------");
		JedisPool jedisPool = JedisUtil.getJedisPoolInstance();		
		Jedis jedis2 = null;
		try {
          jedis2=jedisPool.getResource();
          jedis2.set("k1", "keys value");
          System.out.println("redis �洢���ַ���Ϊ: " + jedis2.get("k1"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JedisUtil.release(jedisPool, jedis2);
		}
	}
}

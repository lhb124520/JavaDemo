package com.demo.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	private static volatile JedisPool jedisPool = null;

	public JedisUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static JedisPool getJedisPoolInstance() {
		synchronized (JedisPool.class) {
			if(jedisPool==null){
				JedisPoolConfig config = new JedisPoolConfig();
				//����һ��pool�ɷ�����ٸ�jedisʵ����ͨ��pool.getResource()����ȡ��
	            //�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��
				config.setMaxTotal(50);
				//����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����
				config.setMaxIdle(5);
				//��ʾ��borrow(����)һ��jedisʵ��ʱ�����ĵȴ�ʱ�䣬��������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException����λ����
				//С����:������ȷ����ʱ��,  Ĭ��-1
				config.setMaxWaitMillis(1000*100);
				//��borrow(����)һ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�
				config.setTestOnBorrow(true);
				//return һ��jedisʵ����poolʱ���Ƿ������ӿ����ԣ�ping()��
				config.setTestOnReturn(true);
				//connectionTimeout ���ӳ�ʱ��Ĭ��2000ms��
				//soTimeout ��Ӧ��ʱ��Ĭ��2000ms��
				jedisPool=new JedisPool(config, "127.0.0.1",6379);
			}
		}
		return jedisPool;

	}
	@SuppressWarnings("deprecation")
	public static void release(JedisPool jedisPool,Jedis jedis){
		if(jedis!=null){
			jedisPool.returnResourceObject(jedis);
		}
	}
}

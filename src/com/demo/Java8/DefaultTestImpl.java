package com.demo.Java8;
/**
 * JAVA8 十大新特性详解
 * @author liu.hb
 *
 */
public class DefaultTestImpl implements DefalutTest {	
	public static void main(String[] args) {
//		DefaultTestImpl stl = new DefaultTestImpl();
//		stl.defaultMethod();

	}

	/**
	 * 接口中的static方法不能被继承，也不能被实现类调用，只能被自身调用
	 */
	@Override
	public int sub(int a, int b) {	
		
		return 0;
	}

}

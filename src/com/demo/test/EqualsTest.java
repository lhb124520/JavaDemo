package com.demo.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class EqualsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		name();
	}
	private static void name() {
//		String cc = new String("123");
		String aa ="123";
		String bb="123";
	
		//System.out.println(aa==bb);
		System.out.println(bb.equals(aa));
//		boolean flag=false;
//		if(bb==aa){
//			flag=true;
//		}
		System.out.println(bb == aa);
		Random random=new Random();
		for(int i=1;i<=145;i++){
			int  a = 303003+random.nextInt(145);
			
			System.out.println(a);
		}		
		
		bb.equals("Apple");
		Integer j=new Integer(8);
	    int m=j.intValue();//手动拆箱
	    int n=j;//自动拆箱 
	    j.valueOf(n);
	    
	    HashSet<String> set =new HashSet<String>();
	    set.add("");
	    TreeSet<String> tree=new TreeSet<String>();
	    tree.add("");
	    HashMap<String, String> aHashMap=new HashMap<>();
	}
	 
}

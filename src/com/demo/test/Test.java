package com.demo.test;
import java.util.HashSet;
import java.util.Iterator;

public class Test {

	public synchronized static void main(String[] args) { 
//		int x,a=5,b=6,c=7;
//		x=++a+b+++c++;
//		System.out.println(x+"");
//        
//		int []i=new int[5];
//		System.out.println(i[4]);

		Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
		System.out.println(g.equals(a + b));
		 HashSet<String> hashSet=new HashSet<String>();
	        hashSet.add("1");
	        hashSet.add("2");
	        hashSet.add("1");
	        Iterator<String> iterator = hashSet.iterator();
	        while (iterator.hasNext()) {
	            String next = iterator.next();
	            System.out.println(next);
	        }	
	        
	}  
   
}

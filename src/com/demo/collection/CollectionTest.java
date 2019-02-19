package com.demo.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
	  HashSet<Object> set;
      List<String> list=new ArrayList<>();
      list.add("1");
      list.add("222");
      list.add("333");
      list.get(0);      
      list.size();
      list.set(0, "2");
      list.iterator();
      Iterator<String> it1 = list.iterator();
      while(it1.hasNext()){
      System.out.println(it1.next());
      }
      list.clear();
	}

}

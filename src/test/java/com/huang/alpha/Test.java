package com.huang.alpha;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentMap<String,String> data = new ConcurrentHashMap<String,String>();
		System.out.println(data.put("A", "B"));
		System.out.println(data.put("A", "B"));

	}

}

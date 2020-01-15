package com.huang.alpha;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Test {

	public static void main(String[] args) {
		Runnable runnable = ()->{
			try {
				System.out.println("before thread");
				Thread.sleep(10000);
				System.out.println("after thread");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		runnable.run();
		System.out.println("main end");

	}

}

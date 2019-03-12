package com.huang.rxjava;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] data = {"spring","tomcat","mysql","mybatis"};
		hello(data);
		

	}
	
	public static void hello(String [] args) {
		Flowable.fromArray(args).subscribe(new Consumer<String>() {
			@Override
			public void accept(String t) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("hello " + t);
				
			}
			
		});
	}

}

package com.huang.alpha.jvm;

public class PermGC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < Integer.MAX_VALUE ; i++) {
			String t = String.valueOf(i).intern();
		}

	}

}

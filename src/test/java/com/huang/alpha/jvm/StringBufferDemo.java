package com.huang.alpha.jvm;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("helloworld");
        StringBuffer sb1 = sb;
        System.out.println(sb == sb1);
    }
}

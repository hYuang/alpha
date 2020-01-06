package com.huang.alpha.jvm;


import org.openjdk.jol.info.ClassLayout;

public class ObjectLayout {
    static Object staticObject = new Object();
    public static void main(String[] args) {
        Object data = new Object();
        System.out.println(ClassLayout.parseInstance(data).toPrintable());
        System.out.println(ClassLayout.parseInstance(staticObject).toPrintable());
    }
}

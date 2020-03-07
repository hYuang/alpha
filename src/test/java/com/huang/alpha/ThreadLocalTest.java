package com.huang.alpha;

import java.io.IOException;

public class ThreadLocalTest {
    public static void  main (String[] args) throws InterruptedException {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("main");
        testEntity.setTime(100);
        TestThread testThread1 =  new TestThread(testEntity);
        //TestThread testThread2 =  new TestThread(testEntity);
        testThread1.start();
        //testThread2.start();
        testThread1.join();
        //testThread2.join();
        System.out.println(testEntity);


    }
}


class TestEntity {
    private  String name ;
    private  long time;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}


class TestThread extends Thread{
    private final   ThreadLocal<TestEntity> threadLocal = new ThreadLocal<>();


    public TestThread(TestEntity testEntity) {
        threadLocal.set(testEntity);
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            getTestEntity().setName(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public TestEntity getTestEntity() {
        return threadLocal.get();
    }
}

package com.huang.alpha.jvm;

import java.util.ArrayList;
import java.util.List;

public class PigInThePython {
    static  volatile List pigs = new ArrayList();
    static  volatile  int pigEaten = 0;
    static final int ENOUGH_PIGS = 5000;

    public static void main(String[] args) {
        new PigEater().start();
        new PigDigester().start();
    }

    static class PigEater extends  Thread{
        @Override
        public void run() {
            while(true){
                pigs.add(new byte[32*1024*1024]);
                if(pigEaten > ENOUGH_PIGS) return;
                takeANap(100);
            }
        }
    }

    static  class PigDigester extends  Thread{
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while(true){
                takeANap(2000);
                pigEaten += pigs.size();
                pigs = new ArrayList();
                System.out.format("Digested %d pigs in %d ms. %n",pigEaten,System.currentTimeMillis()-start);
                return;
            }
        }
    }

    static void takeANap(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

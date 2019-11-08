package com.mythread;

import java.util.concurrent.TimeUnit;

public class Test01 {
 
    public  boolean b = true;
 
    public Object lock = new Object();
 
    public void m() {
        System.out.println("start");
        while(this.b){
            doSomething();
            if(b) {
 
            }
            boolean value = b;
        }
        System.out.println("end"+b);
    }
 
    public void doSomething() {
 
    }
 
    public static void main(String[] args) {
        final Test01 test = new Test01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.m();
            }
        }).start();
 
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  Thread.yield();
        System.out.println("set");
        test.b = false;
    }
}
package com;

import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

public class Singleton1 {
	//¶öººÄ£Ê½
private volatile static Singleton1 instance = null;
private Singleton1(){}

public static Singleton1 getInstance(){
	if(null==instance){
		synchronized (Singleton1.class) {
			if(null==instance)
				instance = new Singleton1();
		}
	}
	return instance;
 }
 static Singleton1 n1;
 static Singleton1 n2;
 static Singleton1 n3;
 static Singleton1 n4;
 
 public  static HashSet set = new HashSet<Singleton1>();
public static void main(String[] args) {

	final CountDownLatch count = new CountDownLatch(2000);
	for(int i =1;i<=2000;i++){
		
		new Thread(){
			@Override
			public void run() {
               try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println(Singleton1.getInstance());
				set.add(Singleton1.getInstance());
				count.countDown();
			}
			
		}.start();
	}
	
	try {
		count.await();
		System.out.println(set.size());
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

 }
}

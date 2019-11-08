package com.mythread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.Singleton1;

public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		
/*		ThreadCountDown t  = new ThreadCountDown();
		t.exec();*/
		
		final CountDownLatch cdl = new CountDownLatch(10);
		
	  for (int i = 0; i < 10; i++) {
		
		  new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println(Thread.currentThread().getName()+Singleton1.getInstance());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cdl.countDown();
			}
		},i+"").start();
	}
		
	  cdl.await();
	  System.out.println("Completed!");
		
	}
	
 ExecutorService exes = Executors.newFixedThreadPool(100);
	
	public void exec(){
		for(int i=0;i<100;++i){
			exes.submit(new getSingleton());
		}
		exes.shutdown();
	}
	class getSingleton implements Runnable{

		@Override
		public void run() {
			System.out.println(Singleton1.getInstance());
			
		}
		
	}
}
		 

	

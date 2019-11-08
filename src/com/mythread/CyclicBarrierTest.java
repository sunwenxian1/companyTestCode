package com.mythread;

import java.time.Duration;
import java.time.Period;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {
	static CyclicBarrier cyclicBarrier = new CyclicBarrier(11);
	     public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
			
	    	 cyclicBarrier.reset();
			for (int i = 0; i < 10; i++) {
				
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							System.out.println(Thread.currentThread().getName()+"到达栅栏");
							TimeUnit.SECONDS.sleep(5);
							cyclicBarrier.await();
							System.out.println(Thread.currentThread().getName()+"继续执行");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BrokenBarrierException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				},i+"").start();
			}
			 cyclicBarrier.await();
			 
			 System.out.println("Complete!!");
		}
	    
}

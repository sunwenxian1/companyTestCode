package com.mythread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	 volatile static int  j = 0;
	public static void main(String[] args) {
		/**
		 * 自定义线程池
		 */
	      	ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 3,
	      			TimeUnit.SECONDS,
	      			new ArrayBlockingQueue<>(1), 
	      			Executors.defaultThreadFactory(), 
	      			new ThreadPoolExecutor.CallerRunsPolicy());
	     
	      	for (int i = 0; i < 10; i++) {
				
	      		threadPoolExecutor.submit(new Thread(()->{
	      			try {
						TimeUnit.SECONDS.sleep(3);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	      			System.out.println(Thread.currentThread().getName()+"---"+j);
	      			j++;
	      		}));
			}
		
	}
	
}

package com.mythread;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteLockTest {

	static Map<String,Object> map = new HashMap<>();
	
	public static void main(String[] args) {
		ReadWriteLock rrl = new ReentrantReadWriteLock();
		
		for (int j = 1; j <= 10; j++) {
			
			new Thread(new Runnable(){
				@Override
				public void run() {
					try{
						rrl.writeLock().lock();
						map.put(UUID.randomUUID().toString(), new Object());
					}
					finally {
						rrl.writeLock().unlock();
					}
					
				}
			},j+"").start();
		}
		for (int j = 1; j <= 10; j++) {
			
			new Thread(new Runnable(){
				@Override
				public void run() {
					try{
						rrl.readLock().lock();
						for (String key:map.keySet()) {
							System.out.println(Thread.currentThread().getName()+"---"+map.get(key));
						}
					}
					finally {
						rrl.readLock().unlock();
					}
					
				}
			},j+"").start();
		}
		
		
		
	}
}

package com.mythread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ThreadCommunicate {
	public static Lock lock = new ReentrantLock(true);
	public static Condition condition1 = lock.newCondition();
	public static Condition condition2 = lock.newCondition();
	public static Condition condition3 = lock.newCondition();
	public static int i = 1;
/*	
	public static void main(String[] args) {
		  new Thread(new Runnable() {
			  
			  @Override
			  public void run() {
				
				  try{
					  lock.lock();
					 // Thread.sleep(200);
					  for (int i = 0; i < 5; i++) {
						  System.out.println(Thread.currentThread().getName()+"-C-");
					}
						
					  
				  }
				 catch (InterruptedException e) {
					  
					  e.printStackTrace();
				  }
				  finally{
					  
					  lock.unlock();
				  }
				  
				  }
		  },"3").start();
		  new Thread(new Runnable() {
			
			@Override
			public void run() {
				
		       		try{
		       		    lock.lock();
		       		    for (int i = 0; i < 7; i++) {
							
		       		    	System.out.println(Thread.currentThread().getName()+"-A-");
						}
							// Thread.sleep(200);
		       		 
		       		}
		       		catch (InterruptedException e) {
		       			
						e.printStackTrace();
					}
		       		finally{
		       			
		       			lock.unlock();
		       		}
			}
		},"1").start();
		  new Thread(new Runnable() {
			  
			  @Override
			  public void run() {
				 
				  try{
					  lock.lock();
					  for (int i = 0; i < 4; i++) {
						
						  System.out.println(Thread.currentThread().getName()+"-B-");
					}
						 // Thread.sleep(200);
					  
				  }
				  catch (InterruptedException e) {
					  
					  e.printStackTrace();
				  }
				  finally{
					  
					  lock.unlock();
				  }
			  }
		  },"2").start();
	}*/

public static void main(String[] args) throws InterruptedException {
	for (int j = 0; j < 5; j++) {
		
	
	  new Thread(new Runnable() {
		
		@Override
		public void run() {
			
	       		try{
	       		    lock.lock();
	       		// for(int j=1;j<=5;j++){
	       		    if(i!=1)
						condition1.await();
					else
						// Thread.sleep(200);
	       		    	System.out.println(Thread.currentThread().getName()+"-A-");
	       		     i = 2;
	       		    	condition2.signal();
	       		    	//if(j<5)
	       		    	//condition1.await();
	       		     
	       		// }
	       		   
	       		}catch (InterruptedException e) {
	       			
					e.printStackTrace();
				}finally{
	       			
	       			lock.unlock();
	       		}
		}
	},"1").start();
	  
	  new Thread(new Runnable() {
		  
		  @Override
		  public void run() {
			 
			  try{
				  lock.lock();
				//  for(int j=1;j<=5;j++){
				  if(i!=2)
					  condition2.await();
				  else
					 // Thread.sleep(200);
					  System.out.println(Thread.currentThread().getName()+"-B-");
					  i = 3;
					  condition3.signal();
					 // if(j<5)
					  //condition2.await();
					 
			//  }
				 
				
			  }catch (InterruptedException e) {
				  
				  e.printStackTrace();
			  }finally{
				  
				  lock.unlock();
			  }
		  }
	  },"2").start();

	  new Thread(new Runnable() {
		  
		  @Override
		  public void run() {
			
			  try{
				  lock.lock();
				//  for(int j=1;j<=5;j++){
				  if(i!=3)
					  condition3.await();
				  else
					//  Thread.sleep(200);
					  System.out.println(Thread.currentThread().getName()+"-C-");
					  i= 1;
					  condition1.signal();
/*					  if(j<5)
					  condition3.await();*/
					 
			//	  }
				 
				
			  }catch (InterruptedException e) {
				  
				  e.printStackTrace();
			  }finally{
				  
				  lock.unlock();
			  }
			  
			  }
	  },"3").start();
  Thread.sleep(1000);
  }
}
}

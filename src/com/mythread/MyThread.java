package com.mythread;

public class MyThread extends Thread{
	
 //static	StringBuffer a = new StringBuffer();
 static StringBuilder a = new StringBuilder();
 public  static   Integer  i =0;
	@Override
	public void run() {
      // a.insert(1,"1");
		
		for(int j = 1;j<=10000;j++){
			synchronized(MyThread.class){
				
			i++;
			
		  }
		}
	}
	
	private synchronized void add(){
		
		i++;
	}
	public static void main(String[] args) {
		MyThread myt1 = new MyThread();
		MyThread myt2 = new MyThread();
		MyThread.a.append("abc");

		myt1.start();
		myt2.start();
		try {
			myt1.join();
			myt2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	
		System.out.println(i);
	}
	
}

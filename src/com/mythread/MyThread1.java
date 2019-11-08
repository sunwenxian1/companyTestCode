package com.mythread;

public class MyThread1 extends Thread{
	private int[] array;
	
	@Override
	public void run() {
       for(int i=100;i>0;i--){
    	   
    	   System.out.println(i+"b");
       }
	}
	
}

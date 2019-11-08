package com.mythread;

public class TestThread {
 
	public static void main(String[] args) {
		MyThread th = new MyThread();
		MyThread1 th1 = new MyThread1();
		
		th.start();
		th1.start();
	}
}

package com;

public class Singleton2 {
	//¶öººÄ£Ê½
private static Singleton2 instance = new Singleton2();
private Singleton2(){}

public static Singleton2 getInstance(){
	
	
	return instance;
}


public static void main(String[] args) {
	
	Singleton2.getInstance();
   }
}

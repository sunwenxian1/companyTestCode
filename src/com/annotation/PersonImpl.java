package com.annotation;
@FirstAnnotation
public class PersonImpl implements PersonInterface {

	
	public PersonImpl() {
		
	}

	@Override
	public String get() {
		
		System.out.println("getting!!!");
		return "success!";
	}

}

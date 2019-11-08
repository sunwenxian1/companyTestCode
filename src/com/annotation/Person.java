package com.annotation;

import net.sf.cglib.proxy.Enhancer;

import org.junit.Test;
@SuppressWarnings("unchecked")
@FirstAnnotation(value = "person01")
public class Person {
  
    public Person(){}
	public String name;
	
	public String get(){
		
		System.out.println("3333333");
		return null;
	}

/*	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
		Class<Person> person = (Class<Person>) Class.forName("com.annotation.Person");
		

		Field[] declaredFields = person.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
		 if(declaredFields[i].isAnnotationPresent(FirstAnnotation.class))
			 
			 declaredFields[i].set("id", declaredFields[i].get("values"));
		}
		
		Person p = new Person();
		System.out.println(p.id);
	}*/
	@Test
	public void test901(){
		try {
			Class<Person> person = (Class<Person>) Class.forName("com.annotation.Person");
			 FirstAnnotation annotation = person.getAnnotation(FirstAnnotation.class);
			 if(annotation!=null){
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(Person.class);
				enhancer.setCallback(null);
				Person p = (Person)enhancer.create();
				try {
					 p.name = annotation.value();
					 System.out.println(p.get());
					 System.out.println("++++++++"+p.name);
				} catch (Exception e) {
					// TODO: handle exception
				}
			 }
		} catch (Exception e) {
            e.printStackTrace();
		}
	 }
 }

class Test1{
	 
	
	private Test1() {
	}


	
}
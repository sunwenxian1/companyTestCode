package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserImpl implements UserInterface {

	@Override
	public void walk() {
		System.out.println("userWalk!");
	}

	@Override
	public void eatFood(String foodName) {
		
		System.out.println("foodName"+foodName);
	}

	@Override
	public void fightTo(Object obj) {
		System.out.println("fightTo"+obj.toString());

		
	}	
	
        public static void main(String[] args) {
    		
    		UserInterface userinterface = (UserInterface) new UserProxy(new UserImpl()).getPorxy();
          
    		userinterface.walk();
    		System.out.println("1"+userinterface.toString());
    		
    		userinterface.eatFood("hambeger");
    		userinterface.fightTo(new Object());
		}



}


class UserProxy{
	public Object obj;
	
	
	public UserProxy(Object obj) {
		this.obj = obj;
	}

	public Object getPorxy() {
	
         Object newProxyInstance = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				Object resObj  = null;
				if(method.getName().contains("eat")){
					 System.out.println("eatting!!!!");
					 resObj = method.invoke(obj, args);
				}else if(method.getName().contains("fight")){
					
					 System.out.println("fight!!!!");
					 resObj = method.invoke(obj, args);
				}else{
					
					 resObj = method.invoke(obj, args);
				}
				
				return resObj;
			}
		});
         
         return newProxyInstance;
	}
	

}
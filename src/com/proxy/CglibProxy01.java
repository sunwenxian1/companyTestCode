package com.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy01 {

	
	public void test01(){
		
		System.out.println("第一个cglib的HelloWord");
	}
	
	public static void main(String[] args) {
		Enhancer hancer = new Enhancer();
		hancer.setSuperclass(CglibProxy01.class);
		hancer.setCallback(new MethodInterceptor(){

			@Override
			public Object intercept(Object obj, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				
				Object invoke = methodProxy.invokeSuper(obj, args);
				
				return invoke;
			}
		});
		
		CglibProxy01 cglibProxy01 = (CglibProxy01)hancer.create();
		System.out.println(cglibProxy01.toString());
		cglibProxy01.test01();
		
	}
}

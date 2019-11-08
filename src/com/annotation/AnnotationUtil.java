package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.Test;
import com.annotation.PersonInterface;

public class AnnotationUtil {
    @SuppressWarnings("unchecked")
	@Test
	public void test() throws SecurityException, NoSuchMethodException, Throwable {
		
	/*	final Class<PersonImpl> personClass = (Class<PersonImpl>)Class.forName("com.annotation.PersonImpl");
		Annotation[] annotations = personClass.getAnnotations();
		PersonImpl newInstance = personClass.newInstance();
		PersonInterface instance  = null;
		Handler handler = new Handler();
		for (int i = 0; i < annotations.length; i++) {
			
			if(FirstAnnotation.class == annotations[i].annotationType())
			{
				instance = (PersonInterface) Proxy.newProxyInstance(this.getClass().getClassLoader(),newInstance.getClass().getInterfaces(),handler);

			}
		}
		try{
			//System.out.println(instance.get());
			System.out.println(instance);
		}catch(Exception e){
			
			e.printStackTrace();
		}*/
    	Handler handler = new Handler();
        Class proxyClass = Proxy.getProxyClass(
        		PersonInterface.class.getClassLoader(), new Class[] { PersonInterface.class });
        PersonInterface f = (PersonInterface) proxyClass.
            getConstructor(new Class[] { InvocationHandler.class }).
            newInstance(new Object[] { handler });
        System.out.println("1"+f.get());

	}
    
    class Handler implements InvocationHandler{


		@Override
		public Object invoke(Object porxy, Method method, Object[] args)
				throws Throwable {
			Object res1 = null;
			//if(method.getName().startsWith("get")){ 
			// System.out.println(porxy.toString()+""+method.getName());
			 res1 = method.invoke(porxy, args);
			
			return res1;
		}
    }
    
    public static void main(String[] args) {
		String str1 = "Aa";
		String str2 = "BBBB";
		
		System.out.println(65*31*2);
		System.out.println(((65<<5)-65)*2);
		
	}
}

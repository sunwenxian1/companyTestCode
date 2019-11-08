package com.mythread;

import java.util.concurrent.*;  
import java.util.Date;  
import java.util.HashMap;
import java.util.List;  
import java.util.ArrayList;  
import java.util.Map;


  
/** 
* 有返回值的线程 
*/  
@SuppressWarnings("unchecked")  
public class Test {  
public static void main(String[] args) throws ExecutionException,  
    InterruptedException {  
   System.out.println("----程序开始运行----");  
   Date date1 = new Date();  
  
   int taskSize = 3;  
   // 创建一个线程池  
   ExecutorService pool = Executors.newFixedThreadPool(taskSize);  
   // 创建多个有返回值的任务  
   List<Future> list = new ArrayList<Future>();  
   for (int i = 1; i <= taskSize; i++) {  
	   MyCallable c = new MyCallable(i + " ");  
    c.methodName=i+"";
    // 执行任务并获取Future对象  
    Future f = pool.submit(c);  
    // System.out.println(">>>" + f.get().toString());  
    list.add(f);  
   }  
   // 关闭线程池  
   pool.shutdown();  
  
   // 获取所有并发任务的运行结果  
   for (Future f : list) {  
    // 从Future对象上获取任务的返回值，并输出到控制台  
    System.out.println(">>>" + f.get());  
   }  
  
   Date date2 = new Date();  
   System.out.println("----程序结束运行----，程序运行时间【"  
     + (date2.getTime() - date1.getTime()) + "毫秒】");  
}  
}  
  
class MyCallable implements Callable<Object> {  
private String taskNum;  
  
MyCallable(String taskNum) {  
   this.taskNum = taskNum;  
}  
public String methodName;

@SuppressWarnings("unchecked")
@Override
public Object call() {
  if("1".equals(methodName)){
	  
	 // ncfCallInAgMonitor.getAgentData();
	  System.out.println("1");
	  
	  return 121;
  }else if("2".equals(methodName)){
	  System.out.println("2");
	  List l = new ArrayList<String>();
	  l.add("2");
	  l.add("3");
	  l.add("4");
	  return l;
  }else if("3".equals(methodName)){
	  System.out.println("3");
	 Map m = new HashMap();
	 m.put(1, "123");
	 m.put(2, "456");
	 return m;
  }
 return null;
} 
}
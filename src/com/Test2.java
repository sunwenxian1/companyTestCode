package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
  public static void main(String[] args) {
	  String testString = "142623198303022324gfgdfgdfg";
	  System.out.println(testString.matches("(.*\\d{14}[0-9a-zA-Z].*)|(.*\\d{17}[0-9a-zA-Z].*)")); 
	  
	  Pattern pattern = Pattern.compile("(\\d{14}[0-9a-zA-Z].*)|(\\d{17}[0-9a-zA-Z].*)");
	  
	  Matcher m = pattern.matcher(testString);
	  if(m.find()) {
	      System.out.println(m.group());
	  }
	 // System.out.println(pattern.matcher(testString).group(1));
   } 
 }

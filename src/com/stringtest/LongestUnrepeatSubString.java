package com.stringtest;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LongestUnrepeatSubString {
	@Test
	void test01() {
		
		String targetString = "adhnfoahdfiaopfuyieou";
		String oldString = "";
		
		for(int i=0;i<targetString.length();i++){
			
			for (int j = i; j < targetString.length()-i-1; j++) {
				
			 String	subString = targetString.substring(i,j);
			 
			 String[] split = subString.split("");
			 Set set = new HashSet();
			 for (int k = 0; k < split.length; k++) {
				set.add(split[k]);
			}
				 
				if(subString.length()>1&&subString.length()==set.size()){//·ÇÖØ¸´
					if(subString.length()>=oldString.length()){
						
						oldString = subString;
					}
			 }
			}
		}
		System.out.println(oldString);
	}

}

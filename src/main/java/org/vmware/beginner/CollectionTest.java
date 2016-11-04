package org.vmware.beginner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTest {
	String[] lang={"java",".Net","Python","C++"};
	public void myArray(){
		System.out.println("Array block continue..");
		System.out.println(lang.length);
		System.out.println("Normal Format of Forloop");
		for(int i=0;i<lang.length;i++){
			System.out.println(lang[i]);
		}
		System.out.println("Second format of ForLoop");
		for(String ele:lang){
			System.out.println(ele);
		}
	}
	public void myList(){
		System.out.println("####ArrayList block continue..");
		List<String> list= new ArrayList<String>();//Allow to expand array dynamic
		List<String> list1 = Arrays.asList(lang); //Doesnt allow to expand array
		List<String> list2 =new ArrayList<String>(Arrays.asList(lang));//Array to list expand dynamic
		System.out.println("length:"+list1.size());
		System.out.println("Array index 2:"+list1.get(2));
		list.add("playstore");
		list.add("irctc");
		list.add("ksrtc");
		System.out.println("list:"+list);
		//list1.add("JavaScript"); 
		for(String l1:list1){
			System.out.println("element:"+l1);
		}
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		list2.add("Perl");
		System.out.println("list2:"+list2);
		
	}
	public void varArgs(String... courses){
		System.out.println("#### varArg block continue....");
		System.out.println(courses.length);
		for(String s: courses){
			System.out.println(s);
		}
	}
}

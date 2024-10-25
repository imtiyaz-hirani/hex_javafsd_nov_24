package com.sms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(1);
		
		List<String> listStr = Arrays.asList(new String[] {"john","harry","emma"});
		
		System.out.println(list);
		System.out.println(listStr);
		
		Collections.sort(list);
		Collections.sort(listStr);
		
		System.out.println(list);
		System.out.println(listStr);
		
		//descending
		Collections.reverse(listStr);
		System.out.println(listStr);
	}
}

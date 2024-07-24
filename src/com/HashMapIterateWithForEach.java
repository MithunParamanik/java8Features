package com;

import java.util.HashMap;
import java.util.Map;

public class HashMapIterateWithForEach {

	public static void main(String[] args) {
		Map<String,String> foodType=new HashMap<String,String>();
		foodType.put("A", "Apple");
		foodType.put("B", "Ball");
		foodType.put("C", "Cat");
		foodType.put("D", "Dog");
		//foodType.forEach((k,v)->System.out.println(k +"="+ v));
		foodType.entrySet().stream().forEach(input->System.out.println(input.getKey()+" "+input.getValue()));
		
		

	}

}

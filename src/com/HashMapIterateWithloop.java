package com;

import java.util.HashMap;
import java.util.Map;

public class HashMapIterateWithloop {

	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String,String>();
		map.put("A", "Apple");
		map.put("B", "Ball");
		map.put("c", "Cat");
		for(Map.Entry<String, String>set:map.entrySet())
		{
		System.out.println(set.getKey()+" = "+ set.getValue());
		}
	}

}

package com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HAshMapWithIterator {

	public static void main(String[] args) {
		Map<String,String> typeIterator=new HashMap<String,String>();
		typeIterator.put("A", "Apple");
		typeIterator.put("B", "Ball");
		typeIterator.put("C", "Cat");
		Iterator<Entry<String, String>> ite=typeIterator.entrySet().iterator();
		while(ite.hasNext())
		{
			Map.Entry<String, String> itr2=ite.next();
			System.out.println(itr2.getKey()+" For "+ itr2.getValue());
			
		}
		

	}

}

package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElement {

	public static void main(String[] args) {
		String input="mitthhuunn";
		  List<String> list = Arrays.stream(input.split(""))
		  .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		  .entrySet().stream()
		  .filter(x->x.getValue()>1)
		  .map(Map.Entry::getKey)
		  .collect(Collectors.toList());
		  System.out.println(list);
		

	}

}

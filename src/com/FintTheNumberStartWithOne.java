package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FintTheNumberStartWithOne {

	public static void main(String[] args) {
		int[]numbers= {1,2,11,4,21,41,8};
		  List<String> StartWithOne = Arrays.stream(numbers)
		  .boxed().map(s->s +"")
		  .filter(s->s.startsWith("1"))
		  .collect(Collectors.toList());
		  System.out.println(StartWithOne);

	}

}

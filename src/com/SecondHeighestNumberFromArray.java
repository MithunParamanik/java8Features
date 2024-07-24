package com;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHeighestNumberFromArray {

	public static void main(String[] args) {
		int[] numbers= {2,5,9,11,8,21,2,1};
		  Integer integer = Arrays.stream(numbers).boxed()
		  .sorted(Comparator.reverseOrder())
		  .skip(1)
		  .findFirst()
		  .get();
		  System.out.println(integer);

	}

}

package com;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class FistSquareAndThenCondition {
	public static void main(String args[])
	{
		int[]nums= {1,2,5,8,9};
		Arrays.stream(nums).map(num->num*num).filter(n->n>5).forEach(System.out::println);
		
		Random random=new Random();
		Stream.generate(random::nextInt).limit(10).forEach(System.out::println);
		LocalDateTime local=LocalDateTime.now();
		System.out.println(local);
		
		
	}

}

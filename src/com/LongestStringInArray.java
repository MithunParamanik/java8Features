package com;

import java.util.Arrays;

public class LongestStringInArray {

	public static void main(String[] args) {
		String[] str= {"java","spring","SpringBoot"};
		String LongestString = Arrays.stream(str)
		.reduce((w1,w2)->w1.length()>w2.length() ? w1:w2)
		.get();
		System.out.println(LongestString);

	}

}

package com;

import java.util.*;

public class MaxSubarray {
	private static Scanner keyboard;

	public static void main(String args[]) {
		System.out.println("Enter Your Comma Separated Sequence Below ");
		keyboard = new Scanner(System.in);
		String intSequence = keyboard.nextLine();
		// splitting the sequence below
		String[] tokens = intSequence.split(",");
		int[] array = new int[tokens.length];
		for (int i = 0; i < tokens.length; i++) {
			array[i] = Integer.parseInt(tokens[i]);
		}

		FindMaxSubarray obj = new FindMaxSubarray();
		// finding maximum sum of sub sequence below
		ReturnObject rtobj = obj.findMss(array, 1, tokens.length);

		System.out.println("Left index:" + rtobj.i);
		System.out.println("Right index:" + rtobj.j);
		System.out.println("Maximum sum:" + rtobj.t);
	}
}
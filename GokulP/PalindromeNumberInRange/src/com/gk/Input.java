package com.gk;

import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int startRange=scanner.nextInt();
		int endRange=scanner.nextInt();
		PalindromeNumber palindrome=new PalindromeNumber();
		
		palindrome.range(startRange, endRange);
		scanner.close();

	}

}
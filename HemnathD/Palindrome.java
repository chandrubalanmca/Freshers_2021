package com.impigier.pack;

import java.util.Scanner;
public class Palindrome {
	public static boolean Plaindrome(int number) {
		int remaninder,sum=0,numbervalue;
		numbervalue=number;  
		//the reverse the given number 
		while(number>0){    
			remaninder=number%10;  
			sum=(sum*10)+remaninder;    
			number=number/10;    
		}//check the given number is equal to reversed number
		//condition is true return true else return false
		if(numbervalue==sum)    
			return true;
		else    
			return false; 
	   }  
	//check the previous number of the palindrome 
	public static int  previouspalindrome(int previous) {
		while(!Plaindrome(previous)) {
			previous--;
		}
		return previous;
	}   
	public static void main(String[] args) {
		//get the value
		Scanner getvalue = new Scanner(System.in);
		int value = getvalue.nextInt();
	    int smaller = previouspalindrome(value-1);
	    System.out.println("The give number is "+value+" the previous number "+smaller);
        getvalue.close();
	    	}
	    } 
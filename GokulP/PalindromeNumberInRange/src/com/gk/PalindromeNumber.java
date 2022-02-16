package com.gk;

public class PalindromeNumber {
	int startRange;
	int endRange;
	
	//setting range
	public void range(int startRange,int endRange) {
		this.startRange=startRange;
		this.endRange=endRange;
		if(startRange>endRange) {
			System.out.println("Please enter valid range");
		}
		else {
		palindromeNumbers(startRange,endRange);
		}
	}
	
    //print the palindrome numbers in range
	private void palindromeNumbers(int startRange, int endRange) {
		System.out.println("Palindrome numbers in range between "+startRange+" and "+endRange+" are");
	    for(int index=startRange;index<=endRange;index++) {
	    	if(isPalindrome(index)) {
	    		System.out.print(index+" ");
	    	}
	    }
	}
	//return true if number is palindrome
	private boolean isPalindrome(int nextNumber) {
		int reversedNum=reverse(nextNumber);
		return nextNumber==reversedNum;
	}
	
	
    //return Reversed Number
	private int reverse(int num) {
		int reverse=0,temp=num;
		while(temp>0) {
			reverse=(reverse*10)+(temp%10);
			temp/=10;
		}
		return reverse;
	}

	
	
	

}

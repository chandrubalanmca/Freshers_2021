package palindrome.number;

import java.util.Scanner;

import java.util.*;

class NextPalindrome {

    public static int nextPalindrome(int n)
    {   
        int i=1, digit, reverse_number=0, number;                
       //For single digit number, next palindrome is n+1       
	   if(n<10)
        {   
            i=0;
			return n+1;
        }

        number=n;             //storing in the n in number to compare it later
        while(i!=0)
        {   reverse_number=0;digit=0;
            n=++number;

            while(n>0)      //reversing the number
            {
                digit=n%10;
                reverse_number=reverse_number*10+digit;
                n=n/10;
            }

            if(reverse_number==number)   //check the reverse number is equal to number or not
            {
               i=0;
				return number;
            }

            else i=1;
        }
		return number;
    }

    public static void main(String[] args)
    {   
       Scanner scan = new Scanner(System.in);
       System.out.print("Input the number: ");
       int n = scan.nextInt();
       if (n>0)
		{	
		 System.out.println("Next palindrome: " + nextPalindrome(n));
		}         
   }
}
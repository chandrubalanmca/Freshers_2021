package com.impiger.autosuggest;


import java.util.Scanner;

public class EmployeeFullName {

    public static void main(String[] args) {


        EmployeeFile exception = new EmployeeFile();
        Scanner setOfCharacter = new Scanner(System.in);
        System.out.println("Enter the Character to search:");
        String  characterSet=setOfCharacter.nextLine();
        int numberOfCharacter=characterSet.length();
        if(numberOfCharacter >= 2) {
            System.out.println(exception.search.suggest(characterSet));
        }else {
            System.out.println("Enter more than 2 character to search");
        }
    }
}



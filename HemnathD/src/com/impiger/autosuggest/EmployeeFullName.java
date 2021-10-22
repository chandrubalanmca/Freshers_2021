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

//        Exception exception=new Exception();
//        List<String> value = new ArrayList<>();
//        Scanner setOfCharacter = new Scanner(System.in);
//        System.out.println("Enter the Character to search:");
//        String val = setOfCharacter.nextLine();
//        int n = val.length();
//        if (n >= 2) {
//            while (exception.scanner.hasNextLine()) {
//                value.add(exception.scanner.nextLine());
//            }
//             search = new SearchData(value);
//            System.out.println(search.suggest(val));
//        } else {
//            System.out.println("Enter more than 2 character to search");
//        }

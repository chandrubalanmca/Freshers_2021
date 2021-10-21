package com.impiger.autosuggest;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Name {
    public Name() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {

//        Scanner scanner= new Scanner(System.in);
        String line = "";
        String splitBy = " ";

//        BufferedReader br =new BufferedReader(new FileReader("C:\\Users\\hemnath.devaraj\\Downloads\\EmployeeList.csv"));
//
//
//        while ((line=br.readLine())!=null){
//            List<String>employee = List.of(line.split(splitBy));
//            Search search= new Search(employee);
//            String value = scanner.nextLine();
//            System.out.println(search.suggest("A"));
//
//        }
        Scanner scanner = new Scanner(new File("D:\\demo\\employee.txt"));
        List<String> value = new ArrayList<>();
        Scanner setOfCharacter = new Scanner(System.in);
        System.out.println("Enter the Character to search:");
        String val = setOfCharacter.nextLine();
        int n = val.length();
        if (n >= 2) {
            while (scanner.hasNextLine()) {
                value.add(scanner.nextLine());
            }
            Search search = new Search(value);
            List<String> employee = List.of(line.split(splitBy));
            System.out.println(search.suggest(val));
        }else{
            System.out.println("Enter more then 2 character to search");
        }
    }
}

//        List<String> words =List.of("hello world", "good dog", "hell boy", "cat", "a", "hel","help","helps other","helping other");
//        Search search= new Search(words);
//        System.out.println((search.suggest(value)));


//        try {
//            Scanner scanner=new Scanner(System.in);
//            String var=scanner.nextLine();
//            BufferedReader br = new BufferedReader(new FileReader("D:\\demo\\employee.txt"));
//            while ((line = br.readLine()) != null) {
//                String[] employee = line.split(splitBy);
//                List<String> value = new ArrayList<>();
//                Search search = new Search((value));
//                System.out.println(search.suggest(var));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    }



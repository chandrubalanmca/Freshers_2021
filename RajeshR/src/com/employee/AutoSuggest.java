package com.employee;

import com.employee.SearchData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoSuggest {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("/Users/rajeshraju.pusapati/Desktop/EmployeeList.csv"));
        List<String> values = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Characters : ");
        String val = input.nextLine();
        int n = val.length();
        if (n >= 2) {
            while (scan.hasNextLine()) {
                values.add(scan.nextLine().trim());
            }
            SearchData search = new SearchData(values);
            List<String> value = search.suggest(val);
            System.out.println(value);
        }
        else {
            System.out.println("Please enter the required characters");
        }
        }
    }


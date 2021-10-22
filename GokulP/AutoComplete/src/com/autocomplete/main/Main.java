package com.autocomplete.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\gokulprakash.kalaise\\AutoComplete\\src\\data\\EmployeeList.csv"));
        AutoSuggest autoSuggest = new AutoSuggest();
        String temp;

        while (scanner.hasNext()) {
            temp = scanner.nextLine().trim();
            if (temp != null) {
                autoSuggest.createNewNode(temp);
            }
        }

        Scanner input = new Scanner(System.in);
        temp = input.next();

        if (temp.length() >= 2)
            System.out.println(autoSuggest.suggestNames(temp));
    }
}


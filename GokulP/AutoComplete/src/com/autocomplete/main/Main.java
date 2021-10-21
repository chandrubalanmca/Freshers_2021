package com.autocomplete.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\gokulprakash.kalaise\\AutoComplete\\src\\data\\EmployeeList.csv"));
        List<String> names = new ArrayList<>();
        Map<String, String> firstAndLastNames = new HashMap<>();
        Map<String, String> lastAndFirstName = new HashMap<>();
        Map<String, String> fullName = new HashMap<>();
        TSTOperations tstOperations = new TSTOperations();
        int index = 0;
        String temp;
        String name[];

        while (scanner.hasNext()) {
            temp = scanner.nextLine().trim();
            name = temp.split(" ");
            index = 0;
            while (index < name.length) {
                if (!name[index].equalsIgnoreCase(" ")) {
                    tstOperations.createNewNode(name[index]);
                }
                index++;
            }
            if (name.length == 1) {
                firstAndLastNames.put(temp, "");
            } else {
                if (name.length == 2) {
                    name = temp.split(" ", 2);
                    if (!firstAndLastNames.containsKey(name[0]))
                        firstAndLastNames.put(name[0], name[1]);
                    else
                        firstAndLastNames.put(name[0], firstAndLastNames.get(name[0]) + "," + name[1]);
                    if (!lastAndFirstName.containsKey(name[1]))
                        lastAndFirstName.put(name[1], name[0]);
                    else
                        lastAndFirstName.put(name[1], lastAndFirstName.get(name[1]) + "," + name[0]);
                } else {
                    if (!fullName.containsKey(name[2]))
                        fullName.put(name[2], name[0] + " " + name[1]);
                    else
                        fullName.put(name[2], fullName.get(name[2]) + "," + name[0] + " " + name[1]);
                }
            }
        }
        Scanner input = new Scanner(System.in);
        List<String> suggestion = new ArrayList<>();
        temp = input.next();

        if (temp.length() > 2)
            names = tstOperations.suggestNames(temp);

        for (String tempName : names) {
            index = 0;

            if (fullName.containsKey(tempName)) {
                name = fullName.get(tempName).split(",");
                while (index < name.length) {
                    suggestion.add(name[index] + " " + tempName);
                    index++;
                }
            }

            if (firstAndLastNames.containsKey(tempName)) {
                index = 0;
                name = firstAndLastNames.get(tempName).split(",");
                while (index < name.length) {
                    suggestion.add(tempName + " " + name[index]);
                    index++;
                }
            }

            if (lastAndFirstName.containsKey(tempName)) {
                index = 0;
                name = lastAndFirstName.get(tempName).split(",");
                while (index < name.length) {
                    suggestion.add(name[index] + " " + tempName);
                    index++;
                }
            }
        }
        System.out.println(suggestion);
    }

}


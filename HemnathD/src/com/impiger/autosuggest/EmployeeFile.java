package com.impiger.autosuggest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeFile {
    SearchData search;

    public EmployeeFile()  {
        List<String> value= new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("D:\\demo\\employee.txt"));
            while (scanner.hasNextLine()){
                value.add(scanner.nextLine());
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        search = new SearchData(value);



    }

}

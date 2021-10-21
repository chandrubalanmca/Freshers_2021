package com.impiger.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class test {
    public static void main(String[] args) throws IOException {
        String line = "";
        String splitBy = " ";

        BufferedReader br = new BufferedReader(new FileReader("D:\\demo\\employee.txt"));
        while ((line = br.readLine()) != null) {
              String[] employee = line.split(splitBy);
//                 List<String> employee = List.of(line.split(splitBy));
            ArrayList<String> employee2 = new ArrayList<String>(Arrays.asList(employee));

            for (String s: employee2)
                 System.out.println(s);

        }
    }
}

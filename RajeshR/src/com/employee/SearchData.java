package com.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class SearchData {
        Map<Character, SearchData> employee;
        char c;
        boolean isWord;

        public SearchData(char c) {
            this.c = c;
            employee = new HashMap<>();
        }

        public SearchData() {
            employee = new HashMap<>();
        }

        public void insert(String word) {
            if (word == null || word.isEmpty())
                return;
            char firstChar = word.charAt(0);
            SearchData emp = employee.get(firstChar);
            if (emp == null) {
                emp = new SearchData(firstChar);
                employee.put(firstChar, emp);
            }

            if (word.length() > 1)
                emp.insert(word.substring(1));
            else
                emp.isWord = true;
        }



        SearchData root;

    public SearchData(List<String> words) {
        root = new SearchData();
        for (String word : words)
            root.insert(word);

    }

    public boolean find(String prefix, boolean exact) {
        SearchData lastNode = root;
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.employee.get(c);
            if (lastNode == null)
                return false;
        }
        return !exact || lastNode.isWord;
    }

    public boolean find(String prefix) {
        return find(prefix, false);
    }

    public void suggestHelper(SearchData root, List<String> list, StringBuffer curr) {
        if (root.isWord) {
            list.add(curr.toString());
        }

        if (root.employee == null || root.employee.isEmpty())
            return;

        for (SearchData child : root.employee.values()) {
            suggestHelper(child, list, curr.append(child.c));
            curr.setLength(curr.length() - 1);
        }
    }

    public List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        SearchData lastNode = root;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.employee.get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }



    }

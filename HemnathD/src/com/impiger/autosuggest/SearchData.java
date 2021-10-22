package com.impiger.autosuggest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchData {
        Map<Character, SearchData> employeeName;
        char character;
        boolean isWord;

        public SearchData(char character) {
            this.character = character;
            employeeName = new HashMap<>();
        }

        public SearchData() {
            employeeName = new HashMap<>();
        }

        public void insert(String word) {
            if (word == null || word.isEmpty())
                return;
            char firstCharacter = word.charAt(0);
            SearchData nextCharacter = employeeName.get(firstCharacter);
            if (nextCharacter == null) {
                nextCharacter = new SearchData(firstCharacter);
                employeeName.put(firstCharacter, nextCharacter);
            }
            if (word.length() > 1)
                nextCharacter.insert(word.substring(1));
            else
                nextCharacter.isWord = true;
        }

    SearchData root;

    public SearchData(List<String> employee) {
        root = new SearchData();
        for (String word : employee)
            root.insert(word);
    }

    public void suggestHelper(SearchData root, List<String> list, StringBuffer current) {
        if (root.isWord) {
            list.add(current.toString());
        }

        if (root.employeeName == null || root.employeeName.isEmpty())
            return;

        for (SearchData child : root.employeeName.values()) {
            suggestHelper(child, list, current.append(child.character));
            current.setLength(current.length() - 1);
        }
    }

    public List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        SearchData lastCharacter = root;
        StringBuffer current = new StringBuffer();
        for (char character : prefix.toCharArray()) {
            lastCharacter = lastCharacter.employeeName.get(character);
            if (lastCharacter == null)
                return list;
            current.append(character);
        }
        suggestHelper(lastCharacter, list, current);
        return list;
    }
}

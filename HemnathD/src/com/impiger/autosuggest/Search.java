package com.impiger.autosuggest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search {



    public class SearchData{
        Map<Character,SearchData> nextValue;
        char character;
        boolean isWord;

        public SearchData(char character){
            this.character=character;
            nextValue =new HashMap<>();
        }
        public SearchData(){
            nextValue = new HashMap<>();
        }

        public void insert(String word){
            if (word==null||word.isEmpty())
                return;
            char firstCharacter = word.charAt(0);
            SearchData nextCharacter =nextValue.get(firstCharacter);
            if (nextCharacter == null){
                nextCharacter = new SearchData(firstCharacter);
                nextValue.put(firstCharacter,nextCharacter);
            }
            if(word.length()>1)
                nextCharacter.insert(word.substring(1));
            else
                nextCharacter.isWord = true;
        }
    }
    SearchData root;
    public Search(List<String> employee) {
        root = new SearchData();
        for (String word:employee)
            root.insert(word);
    }

    public boolean find(String prefix, boolean exact){
        SearchData lastNode = root;
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.nextValue.get(c);
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

        if (root.nextValue == null || root.nextValue.isEmpty())
            return;

        for (SearchData child : root.nextValue.values()) {
            suggestHelper(child, list, curr.append(child.character));
            curr.setLength(curr.length() - 1);
        }
    }
    public List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        SearchData lastNode = root;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.nextValue.get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }
}

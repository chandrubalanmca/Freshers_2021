package com.autocomplete.main;

import java.util.ArrayList;
import java.util.List;

public class AutoSuggest {
    private Name[] nodes;
    private String temp;
    protected final int alphabets = 26;
    private List<String> names = new ArrayList<>();
    private StringBuffer name = new StringBuffer();

    public AutoSuggest() {
        nodes = new Name[alphabets];
        for (int index = 0; index < alphabets; index++) {
            nodes[index] = null;
        }
    }


    public void createNewNode(List<String> names) {
        names.forEach(name -> createNewNode(name));
    }

    public Name createNewNode(char ch) {
        Name node = new Name();
        node.setValue(ch);
        node.setLeft(null);
        node.setRight(null);
        node.setMiddle(null);
        return node;
    }

    public void createNewNode(String name) {
        char firstChar = name.toLowerCase().charAt(0);
        int index = firstChar - 'a';
        nodes[index] = createNewNode(nodes[index], name);
    }

    public Name createNewNode(Name node, String name) {
        if (name.length() == 0) {
            return null;
        }
        char head = name.charAt(0);
        String tail = name.substring(1);
        if (node == null) {
            node = createNewNode(head);
        }
        if (head < node.getValue()) {
            node.setLeft(createNewNode(node.getLeft(), name));
        } else if (head > node.getValue()) {
            node.setRight(createNewNode(node.getRight(), name));
        } else {
            if (tail.length() == 0) {
                node.setEndOfName(true);
                return node;
            } else {
                node.setMiddle(createNewNode(node.getMiddle(), tail));
            }
        }
        return node;
    }

    public List<String> suggestNames(String prefix) {
        char firstChar = prefix.toLowerCase().charAt(0);
        int index = firstChar - 'a';
        if (nodes[index] == null) {
            return null;
        } else {
            return searchName(nodes[index], prefix);
        }
    }

    public List<String> searchName(Name node, String prefix) {
        char head = prefix.charAt(0);
        String tail = prefix.substring(1);
        if (head < node.getValue()) {
            searchName(node.getLeft(), prefix);
        } else if (head > node.getValue()) {
            searchName(node.getRight(), prefix);
        } else {
            name.append(head);
            if (tail.length() == 0) {
                return allNames(node.getMiddle(), name.toString());
            }
            searchName(node.getMiddle(), tail);
        }
        return names;
    }

    private List<String> allNames(Name node, String prefix) {
        if (node.isEndOfName()) {
            prefix = prefix + node.getValue();
            names.add(prefix);
            prefix = prefix.substring(0, (prefix.length()) - 1);
        }
        if (node.getMiddle()!= null) {
            allNames(node.getMiddle(), prefix + node.getValue());
        }
        if (node.getLeft()!= null) {
            allNames(node.getLeft(), prefix);
        }
        if (node.getRight() != null) {
            allNames(node.getRight(), prefix);
        }
        return names;
    }
}

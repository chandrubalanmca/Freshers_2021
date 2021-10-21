package com.autocomplete.main;

import java.util.ArrayList;
import java.util.List;

public class TSTOperations {
    Node[] nodes;
    String temp;
    protected final int alphabets = 26;
    List<String> names = new ArrayList<>();
    StringBuffer name = new StringBuffer();

    public TSTOperations() {
        nodes = new Node[alphabets];
        for (int index = 0; index < alphabets; index++) {
            nodes[index] = null;
        }
    }

    public void createNewNode(List<String> names){
        names.forEach(name->createNewNode(name));
    }

    public Node createNewNode(char ch) {
        Node node = new Node();
        node.value = ch;
        node.left = null;
        node.right = null;
        node.middle = null;
        return node;
    }

    public void createNewNode(String name){
        char firstChar = name.toLowerCase().charAt(0);
        int index = firstChar - 'a';
            nodes[index] = createNewNode(nodes[index], name);
    }

    public Node createNewNode(Node node, String name) {
        if (name.length() == 0) {
            return null;
        }
        char head = name.charAt(0);
        String tail = name.substring(1);
        if (node == null) {
            node = createNewNode(head);
        }
        if (head < node.value) {
            node.left = createNewNode(node.left, name);
        }
        else if (head > node.value) {
            node.right = createNewNode(node.right, name);
        }
        else {
            if (tail.length() == 0) {
                node.endOfName = true;
                return node;
            } else {
                node.middle = createNewNode(node.middle, tail);
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

    public List<String> searchName(Node node, String prefix) {
        char head = prefix.charAt(0);
        String tail = prefix.substring(1);
        if (head < node.value) {
            searchName(node.left, prefix);
        } else if (head > node.value) {
            searchName(node.right, prefix);
        } else {
            name.append(head);
            if (tail.length() == 0) {
                return allNames(node.middle, name.toString());
            }
            searchName(node.middle, tail);
        }
        return names;
    }

    private List<String> allNames(Node node, String prefix) {
        if (node.endOfName) {
            prefix = prefix + node.value;
            names.add(prefix);
            prefix=prefix.substring(0,(prefix.length())-1);
        }
        if (node.middle != null) {
            allNames(node.middle, prefix + node.value);
        }
        if (node.left != null) {
            allNames(node.left, prefix);
        }
        if (node.right != null) {
            allNames(node.right, prefix);
        }
        return names;
    }
}

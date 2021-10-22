package com.autocomplete.main;

public class Name {
    private Character value;
    private Name left;
    private Name middle;
    private Name right;
    private boolean endOfName;

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public Name getLeft() {
        return left;
    }

    public void setLeft(Name left) {
        this.left = left;
    }

    public Name getMiddle() {
        return middle;
    }

    public void setMiddle(Name middle) {
        this.middle = middle;
    }

    public Name getRight() {
        return right;
    }

    public void setRight(Name right) {
        this.right = right;
    }

    public boolean isEndOfName() {
        return endOfName;
    }

    public void setEndOfName(boolean endOfName) {
        this.endOfName = endOfName;
    }
}

package com.undoredo.manager;

import java.util.Stack;

public class UndoRedoManager {
    private Stack<String> undoStack;
    private Stack<String> redoStack;
    String temp = "";

    public UndoRedoManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void setAction(String userAction) {
        undoStack.push(userAction);
        redoStack.clear();
        System.out.println(userAction + " Action done");

    }

    public void undo() {
        if (canUndo()) {
            temp = undoStack.pop();
            redoStack.push(temp);
            System.out.println(actionManager(temp));
        } else {
            System.out.println("No Actions to undo");
        }
    }

    public void redo() {
        if (canRedo()) {
            temp = redoStack.pop();
            undoStack.push(temp);
            System.out.println("redone "+ temp);
        } else {
            System.out.println("No Actions to redo");
        }
    }

    private boolean canRedo() {
        return !redoStack.empty();
    }

    public boolean canUndo() {
        return !undoStack.empty();
    }

    public String actionManager(String str) {
        String[] tempString = str.split(" ");
        String action = tempString[0];
        if (action.equalsIgnoreCase("insert"))
            return "Deleted " + tempString[1];
        else if (action.equalsIgnoreCase("delete"))
            return "Inserted " + tempString[1];
        else
            return "undid " + str;
    }


}

package com.undoredo.input;

import com.undoredo.manager.UndoRedoManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainManager {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        UndoRedoManager undoRedoManager = new UndoRedoManager();
        List<String> input = new ArrayList<>();
        String userInput = "";

        while (!(userInput = scanner.nextLine()).equalsIgnoreCase("")) {
            input.add(userInput);
            if (userInput.equalsIgnoreCase("undo"))
                undoRedoManager.undo();
            else if (userInput.equalsIgnoreCase("redo"))
                undoRedoManager.redo();
            else
                undoRedoManager.setAction(userInput);
        }
    }
}

package com.impiger.undoredo;

import java.util.Stack;

public class RevertAndReplay {


    Stack<String> Undo = new Stack<String>();

    Stack<String> Redo = new Stack<String>();


    void Write(Stack<String> Undo, String value){

        Undo.push(value);
    }

    void setUndo(Stack<String> Undo, Stack <String> Redo){

        String value=Undo.peek();

        Undo.pop();

        Redo.push(value);
    }

    void setRedo(Stack<String> Undo, Stack<String> Redo){

        String value = Redo.peek();

        Redo.pop();

        Undo.push(value);

    }

    void getRead(Stack<String> Undo){

        Stack<String> reverseOrder = new Stack<String>();

        while (Undo.size()>0){

            reverseOrder.push(Undo.peek());

            Undo.pop();
        }

        while (reverseOrder.size()>0){

            System.out.println(reverseOrder.peek());

            Undo.push(reverseOrder.peek());

            reverseOrder.pop();
        }

        System.out.print("");
    }

    void getValues(String[] queue){

        int number= queue.length;

        for (int i = 0; i < number; i++){
            if (queue[i].equalsIgnoreCase("Undo")){
                setUndo(Undo,Redo);
            }
            else if (queue[i].equalsIgnoreCase("Redo")){
                setRedo(Undo,Redo);
            }
            else if (queue[i].equalsIgnoreCase("Read")){
                getRead(Undo);
            }
            else {
                Write(Undo,queue[i]);
            }
        }
    }

    void getInsertRow(String[] action,String[] queue){

        System.out.println(action[0]);

        int number=queue.length;
        for (int i= 0;i<number;i++) {

            if (action[0].equalsIgnoreCase("InsertRow")) {

                if (queue[i].equalsIgnoreCase("Undo")){
                    System.out.println("delete inserted row");
                }
                else {
                    System.out.println("reinsert row");
                }
            }
        }

    }
    void getDeleteRow(String[] action,String[] queue){

        System.out.println(action[1]);

        int number=queue.length;
        for (int i= 0;i<number;i++) {

            if (action[1].equalsIgnoreCase("DeleteRow")) {

                if (queue[i].equalsIgnoreCase("Undo")){
                    System.out.println("reinsert deleted row ");
                }
                else {
                    System.out.println("delete the same row");
                }
            }
        }

    }
    void getInsertColumn(String[] action,String[] queue){

        System.out.println(action[2]);

        int number=queue.length;
        for (int i= 0;i<number;i++) {

            if (action[2].equalsIgnoreCase("InsertColumn")) {

                if (queue[i].equalsIgnoreCase("Undo")){
                    System.out.println("delete inserted Column");
                }
                else {
                    System.out.println("reinsert Column");
                }
            }
        }

    }
    void getDeleteColumn(String[] action,String[] queue){

        System.out.println(action[3]);

        int number=queue.length;
        for (int i= 0;i<number;i++) {

            if (action[3].equalsIgnoreCase("DeleteColumn")) {

                if (queue[i].equalsIgnoreCase("Undo")){
                    System.out.println("reinsert deleted Column ");
                }
                else {
                    System.out.println("delete the same Column");
                }
            }
        }

    }
    void getInsertCell(String[] action,String[] queue){

        System.out.println(action[4]);

        int number=queue.length;
        for (int i= 0;i<number;i++) {

            if (action[4].equalsIgnoreCase("InsertCell")) {

                if (queue[i].equalsIgnoreCase("Undo")){
                    System.out.println("delete inserted Cell");
                }
                else {
                    System.out.println("reinsert Cell");
                }
            }
        }

    }
    void getDeleteCell(String[] action,String[] queue){

        System.out.println(action[5]);

        int number=queue.length;
        for (int i= 0;i<number;i++) {

            if (action[5].equalsIgnoreCase("DeleteCell")) {

                if (queue[i].equalsIgnoreCase("Undo")){
                    System.out.println("reinsert deleted Cell ");
                }
                else {
                    System.out.println("delete the same Cell");
                }
            }
        }

    }


}

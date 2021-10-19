package com.impiger.undoredo;

import java.util.Scanner;

public class UserAction {
    public static void main(String[] args) {

        RevertAndReplay function = new RevertAndReplay();

        Scanner scan =new Scanner(System.in);


        String[] action = new String[]{"InsertRow","DeleteRow","InsertColumn","DeleteColumn","InsertCell","DeleteCell"};
        String[] queue={"hello","Undo","redo"};
        function.getInsertRow(action,queue);
        function.getDeleteRow(action,queue);
        function.getInsertColumn(action,queue);
        function.getDeleteColumn(action,queue);
        function.getInsertCell(action,queue);
        function.getDeleteCell(action,queue);

    }
}
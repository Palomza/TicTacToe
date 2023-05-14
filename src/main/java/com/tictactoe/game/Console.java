package com.tictactoe.game;

public class Console {

    public static void drawBoard(char[][] board, int boardSize){
        String line;
        for(int i = 0; i< boardSize; i++){
            for(int j = 0; j< boardSize; j++){
                System.out.print(" " + board[i][j] + " ");
                if(j != boardSize-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i != boardSize-1) {
                line = "";
                for(int k = 0; k< boardSize; k++) {
                    line = line + "---+";
                }
                System.out.println(line.substring(0, line.length()-1));
            }
        }
    }

    public static void fillBoard(int boardSize, char[][] board, char blankSpace){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                board[i][j] = blankSpace;
            }
        }
    }
}

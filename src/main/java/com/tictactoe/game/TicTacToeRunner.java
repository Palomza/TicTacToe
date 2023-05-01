package com.tictactoe.game;

import java.util.Scanner;

public class TicTacToeRunner {
    private String[] markBoard = new String[9];
    private int moveCounter = 0;
    private boolean gameOver = false;
    private boolean xTurn = true;

    public TicTacToeRunner() {
        fillABoard();
        drawBoard();
        turnInfo();
        gameStateChecker();
    }

    public void drawBoard(){
        System.out.println("|"+markBoard[0]+"|"+markBoard[1]+"|"+markBoard[2]+"|");
        System.out.println("|"+markBoard[3]+"|"+markBoard[4]+"|"+markBoard[5]+"|");
        System.out.println("|"+markBoard[6]+"|"+markBoard[7]+"|"+markBoard[8]+"|");
    }

    public void fillABoard(){
        for(int i = 0; i< markBoard.length; i++){
            markBoard[i] = String.valueOf(i+1);
            moveCounter++;
        }

    }

    public void xPlayerMove(){
        System.out.println("Player X, it's your turn! Pick a number.");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        markBoard[i-1] = "X";
        moveCounter--;
        turnInfo();
        drawBoard();
    }
    public void oPlayerMove(){
        System.out.println("Player O, it's your turn! Pick a number.");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        markBoard[i-1] = "O";
        moveCounter--;
        turnInfo();
        drawBoard();
    }

    public void playerMoveChanger(){
        if(xTurn){
            xPlayerMove();
            xTurn = false;
        } else {
            oPlayerMove();
            xTurn = true;
        }
    }

    public void gameStateChecker(){
        while(!gameOver){
            if(moveCounter > 0){
                playerMoveChanger();
            } else {
                System.out.println("Game over!");
                break;
            }
        }
    }

    public void turnInfo(){
        System.out.println("Ruch nr - " + moveCounter);
    }


    public static void main(String[] args) {
        new TicTacToeRunner();
    }
}

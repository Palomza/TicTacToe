package com.tictactoe.game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeRunner {

    private final int boardSize = 3;
    private final int draw = 0;
    private final int oTurn = 1;
    private final int xTurn = 2;
    private final int noWin = 0;
    private final int oWin = 1;
    private final int xWin = 2;
    private final char oMark = 'O';
    private final char xMark = 'X';
    private final char blankSpace = ' ';
    private final char[][] board = new char[boardSize][boardSize];
    private final Scanner scanner = new Scanner(System.in);

    public int getBoardSize() {
        return boardSize;
    }

    public int getDraw() {
        return draw;
    }

    public int getoTurn() {
        return oTurn;
    }

    public int getxTurn() {
        return xTurn;
    }

    public int getNoWin() {
        return noWin;
    }

    public int getoWin() {
        return oWin;
    }

    public int getxWin() {
        return xWin;
    }

    public char getoMark() {
        return oMark;
    }

    public char getxMark() {
        return xMark;
    }

    public char getBlankSpace() {
        return blankSpace;
    }

    public char[][] getBoard() {
        return board;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void startGame(){
        System.out.println("Tic Tac Toe");
        fillBoard();
        int gameState = noWin;

        do{
            drawBoard();
            makeAMove();
            gameState = checkGameState();
        } while (gameState == noWin);

        drawBoard();
        switch(gameState){
            case xWin:
                System.out.println("Player "+ xMark + " just won!");
                break;
            case oWin:
                System.out.println("Player "+ oMark + " just won!");
                break;
            case draw:
                System.out.println("No winners, it's a draw!");
                break;
        }
    }

    public void drawBoard(){
        for(int i = 0; i< boardSize; i++){
            for(int j = 0; j< boardSize; j++){
                System.out.print(" " + board[i][j] + " ");
                if(j != boardSize-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i != boardSize-1) {
                System.out.println("---+---+---");
            }
        }
    }

    public void fillBoard(){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                board[i][j] = blankSpace;
            }
        }
    }

    public void makeAMove(){
        int row;
        int column;

        do {
            try {
                System.out.println("Player " + nextPlayer() + " it's your turn:");
                System.out.println("Pick a row (1-" + boardSize + "): ");
                row = scanner.nextInt() - 1;
                System.out.println("Pick a column (1-" + boardSize + "): ");
                column = scanner.nextInt() - 1;

                if(!validateMove(row, column)){
                    throw new IllegalArgumentException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); //clear scanner buffer
                row = -1;
                column = -1;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move! Please try again.");
                scanner.nextLine(); //clear scanner buffer
                row = -1;
                column = -1;
            }
        }while(row < 0 || column < 0);

        if(nextPlayer() == oTurn){
            board[row][column] = oMark;
        } else {
            board[row][column] = xMark;
        }
    }

    public boolean validateMove(int row, int column){
        if(row < 0 || row >= boardSize || column < 0 || column >= boardSize){
            System.out.println("Your pick is out the board!");
            return false;
        } else if (board[row][column] != blankSpace){
            System.out.println("This field is already picked!");
            return false;
        }
        return true;
    }

    public int nextPlayer(){
        int emptySpaces = countEmptySpaces();
        if(emptySpaces % 2 == 0){
            return oTurn;
        } else {
            return xTurn;
        }
    }

    public int countEmptySpaces(){
        int moves = 0;
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(board[i][j] == xMark || board[i][j] == oMark){
                    moves++;
                }
            }
        }
        return moves;
    }

    public int checkRows(){
        for(int i = 0; i < boardSize; i++){
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                if(board[i][0] == oMark){
                    return oWin;
                } else if (board[i][0] == xMark){
                    return xWin;
                }
            }
        }
        return noWin;
    }

    public int checkColumns(){
        for(int i = 0; i<boardSize; i++){
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                if(board[0][i] == oMark){
                    return oWin;
                } else if(board[0][i] == xMark){
                    return xWin;
                }
            }
        }
        return noWin;
    }

    public int checkDiagonal(){
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            if(board[0][0] == oMark){
                return oWin;
            } else if(board[0][0] == xMark){
                return xWin;
            }
        }

        if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            if(board[0][2] == oMark){
                return oWin;
            } else if(board[0][2] == xMark){
                return xWin;
            }
        }
        return noWin;
    }

    public boolean checkIfDraw(){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(board[i][j] == blankSpace){
                    return false;
                }
            }
        }
        return true;
    }

    public int checkGameState(){
        int checker;

        checker = checkRows();
        if(checker != noWin){
            return checker;
        }

        checker = checkColumns();
        if(checker != noWin){
            return checker;
        }

        checker = checkDiagonal();
        if(checker != noWin){
            return checker;
        }

        if(checkIfDraw()) {
            return draw;
        }

        return noWin;
    }

    public static void main(String[] args) {
        TicTacToeRunner runner = new TicTacToeRunner();
        runner.startGame();
    }
}

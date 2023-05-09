package com.tictactoe.game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeRunner {

    private int boardSize = 3; // default board size
    private final int draw = 0;
    private final int oTurn = 1;
    private final int xTurn = 2;
    private final int noWin = 0;
    private final int playerVsPlayer = 0;
    private final int playerVsPc = 1;
    private final int oWin = 1;
    private final int xWin = 2;
    private final char oMark = 'O';
    private final char xMark = 'X';
    private final char blankSpace = ' ';
    private char[][] board;
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

    public void startGame() {
        System.out.println("Tic Tac Toe\n");

        int gameState = noWin;
        int gameMode = setGameMode();
        boardSize = setBoardSize();
        board = new char[boardSize][boardSize];
        fillBoard();
        boolean pcTurn = false;

        if(gameMode == playerVsPlayer) {
            do {
                drawBoard();
                makeAMove();
                gameState = checkGameState();
            } while (gameState == noWin);
        } else if(gameMode == playerVsPc) {
            do {
                if(pcTurn == false) {
                    drawBoard();
                    makeAMove();
                    pcTurn = true;
                    gameState = checkGameState();
                } else {
                    drawBoard();
                    makeAMoveVsPc();
                    pcTurn = false;
                    gameState = checkGameState();
                }
            } while (gameState == noWin);
        }

        drawBoard();
        switch (gameState) {
            case xWin:
                System.out.println("Player " + xMark + " just won!");
                break;
            case oWin:
                System.out.println("Player " + oMark + " just won!");
                break;
            case draw:
                System.out.println("No winners, it's a draw!");
                break;
        }
    }

    public void drawBoard(){
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

    public void fillBoard(){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                board[i][j] = blankSpace;
            }
        }
    }

    public int setBoardSize(){
        int boardSize;
        do {
            try{
                System.out.println("Pick a board size, type:");
                System.out.println("\"1\" for 3x3 board (3 in a row/column/diagonal to win)");
                System.out.println("\"2\" for 10x10 board (5 in a row/column/diagonal to win) - NOT WORKING FOR NOW");
                boardSize = scanner.nextInt();

                if(validateBoardSize(boardSize)) {
                    throw new IllegalArgumentException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please enter a number.");
                scanner.nextLine();
                boardSize = -1;
            } catch (IllegalArgumentException e){
                System.out.println("Invalid choice! Please select 1 or 2.");
                boardSize = -1;
            }

            }while(boardSize < 0);
        if(boardSize == 1){
            boardSize = 3;
        } else if (boardSize == 2){
            boardSize = 10;
        }
        return boardSize;
    }

    public boolean validateBoardSize(int boardSize){
        if(boardSize == 1 || boardSize == 2){
            return false;
        } else {
            return true;
        }
    }

    public int setGameMode(){
        int gameMode;
        do {
            try {
                System.out.println("Pick a game mode, type:");
                System.out.println("\"1\" for Player vs Player");
                System.out.println("\"2\" for Player vs Computer");
                gameMode = scanner.nextInt() - 1;

                if(validateGameMode(gameMode)) {
                throw new IllegalArgumentException();
                }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input! Please enter a number.");
                    scanner.nextLine();
                    gameMode = -1;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid choice! Please select 1 or 2.");
                    scanner.nextLine();
                    gameMode = -1;
                }
            }while(gameMode < 0);
        return gameMode;
        }

    public boolean validateGameMode(int gameMode) {
        if (gameMode == 0 || gameMode == 1) {
            return false;
        } else {
            return true;
        }
    }

    public void makeAMove(){
        int row;
        int column;

        do {
            try {
                System.out.println("Player " + nextPlayer() + " it's your turn");
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

    public void makeAMoveVsPc(){
        int row;
        int column;

        do {
            do {
                row = (int) (Math.random() * boardSize);
                column = (int) (Math.random() * boardSize);
            }while(!validatePcMove(row, column));

        }while(row < 0 || column < 0);

        System.out.println("Computer picked row "+ (row+1)+ " and column "+ (column +1));

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

    public boolean validatePcMove(int row, int column){
        if (board[row][column] != blankSpace){
            return false;
        } else {
            return true;
        }
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

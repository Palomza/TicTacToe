package com.tictactoe.game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeRunner {

    private int boardSize = 3; //default board size
    private int marksToWin = 3; //default value of marks in line to win
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
    private char[][] board = new char[boardSize][boardSize];
    private final Scanner scanner = new Scanner(System.in);

    public int getBoardSize() {
        return boardSize;
    }

    public int getMarksToWin() {
        return marksToWin;
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

    public int getPlayerVsPlayer() {
        return playerVsPlayer;
    }

    public int getPlayerVsPc() {
        return playerVsPc;
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
        marksToWin = setMarksInLineToWin(); // 3 in line for 3x3, 5 in line for 10x10
        board = new char[boardSize][boardSize];
        Console.fillBoard(boardSize, board, blankSpace);
        boolean pcTurn = false;

        if(gameMode == playerVsPlayer) {
            do {
                Console.drawBoard(board, boardSize);
                makeAMove();
                gameState = GameStateChecker.checkGameState(boardSize, board, oMark, xMark, blankSpace, oWin,
                        xWin, noWin, marksToWin, draw);
            } while (gameState == noWin);
        } else if(gameMode == playerVsPc) {
            do {
                if(pcTurn == false) {
                    Console.drawBoard(board, boardSize);
                    makeAMove();
                    pcTurn = true;
                    gameState = GameStateChecker.checkGameState(boardSize, board, oMark, xMark, blankSpace, oWin,
                            xWin, noWin, marksToWin, draw);
                } else {
                    Console.drawBoard(board, boardSize);
                    makeAMoveVsPc();
                    pcTurn = false;
                    gameState = GameStateChecker.checkGameState(boardSize, board, oMark, xMark, blankSpace, oWin,
                            xWin, noWin, marksToWin, draw);
                }
            } while (gameState == noWin);
        }

        Console.drawBoard(board, boardSize);;
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

    public int setMarksInLineToWin(){
        int marks;

        if(boardSize <= 9){
            marks = 3;
        } else {
            marks = 5;
        }
        return marks;
    }

    public int setBoardSize(){
        int boardSize;
        do {
            try{
                System.out.println("Pick a board size, type:");
                System.out.println("\"1\" for 3x3 board (3 in a row/column/diagonal to win)");
                System.out.println("\"2\" for 10x10 board (5 in a row/column/diagonal to win)");
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

    public static void main(String[] args) {
        TicTacToeRunner runner = new TicTacToeRunner();
        runner.startGame();
    }
}

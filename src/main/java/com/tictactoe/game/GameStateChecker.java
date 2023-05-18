package com.tictactoe.game;

public class GameStateChecker {


    public static int checkGameState(int boardSize, char board[][], char oMark, char xMark, char blankSpace,
                              int oWin, int xWin, int noWin, int marksToWin, int draw){
        int checker;

        checker = checkRows(boardSize, board, oMark, xMark, oWin, xWin, noWin, marksToWin);
        if(checker != noWin){
            return checker;
        }

        checker = checkColumns(boardSize, board, oMark, xMark, oWin, xWin, noWin, marksToWin);
        if(checker != noWin){
            return checker;
        }

        checker = checkDiagonal(boardSize, board, oMark, xMark, oWin, xWin, noWin, marksToWin);
        if(checker != noWin){
            return checker;
        }

        if(checkIfDraw(boardSize, board, blankSpace)) {
            return draw;
        }

        return noWin;
    }
    public static int checkRows(int boardSize, char board[][], char oMark, char xMark,
                         int oWin, int xWin, int noWin, int marksToWin){
        //check if o wins
        for(int i = 0; i < boardSize; i++){
            int markCountOWin = 0;
            for(int j = 0; j < boardSize; j++){
                if(board[i][j] == oMark) {
                    markCountOWin++;
                    if(markCountOWin == marksToWin){
                        return oWin;
                    }
                } else {
                    markCountOWin = 0;
                }
            }
        }
        //check if x wins
        for(int i = 0; i < boardSize; i++){
            int markCountXWin = 0;
            for(int j = 0; j < boardSize; j++){
                if(board[i][j] == xMark) {
                    markCountXWin++;
                    if(markCountXWin == marksToWin){
                        return xWin;
                    }
                } else {
                    markCountXWin = 0;
                }
            }
        }
        return noWin;
    }

    public static int checkColumns(int boardSize, char board[][], char oMark, char xMark,
                            int oWin, int xWin, int noWin, int marksToWin){
        //check if o wins
        for(int j = 0; j < boardSize; j++){
            int markCountOWin = 0;
            for(int i = 0; i < boardSize; i++){
                if(board[i][j] == oMark) {
                    markCountOWin++;
                    if(markCountOWin == marksToWin){
                        return oWin;
                    }
                } else {
                    markCountOWin = 0;
                }
            }
        }
        //check if x wins
        for(int j = 0; j < boardSize; j++){
            int markCountXWin = 0;
            for(int i = 0; i < boardSize; i++){
                if(board[i][j] == xMark) {
                    markCountXWin++;
                    if(markCountXWin == marksToWin){
                        return xWin;
                    }
                } else {
                    markCountXWin = 0;
                }
            }
        }
        return noWin;
    }

    public static int checkDiagonal(int boardSize, char board[][], char oMark, char xMark,
                             int oWin, int xWin, int noWin, int marksToWin){
        //Diagonals
        for(int i = 0; i < boardSize-marksToWin+1; i++){
            for(int j = 0; j < boardSize-marksToWin+1; j++){
                boolean win = true;
                for(int k = 0; k < marksToWin; k++){
                    if(board[i+k][j+k] != oMark){
                        win = false;
                        break;
                    }
                }
                if(win == true){
                    return oWin;
                }
            }
        }
        for(int i = 0; i < boardSize-marksToWin+1; i++){
            for(int j = 0; j < boardSize-marksToWin+1; j++){
                boolean win = true;
                for(int k = 0; k < marksToWin; k++){
                    if(board[i+k][j+k] != xMark){
                        win = false;
                        break;
                    }
                }
                if(win == true){
                    return xWin;
                }
            }
        }
        //Anti-diagonals
        for(int i = 0; i < boardSize-marksToWin+1; i++){
            for(int j = marksToWin-1; j<boardSize; j++){
                boolean win = true;
                for(int k = 0; k < marksToWin; k++){
                    if(board[i+k][j-k] != oMark) {
                        win = false;
                        break;
                    }
                }
                if(win == true){
                    return oWin;
                }
            }
        }
        for(int i = 0; i < boardSize-marksToWin+1; i++){
            for(int j = marksToWin-1; j<boardSize; j++){
                boolean win = true;
                for(int k = 0; k < marksToWin; k++){
                    if(board[i+k][j-k] != xMark) {
                        win = false;
                        break;
                    }
                }
                if(win == true){
                    return xWin;
                }
            }
        }
        return noWin;
    }

    public static boolean checkIfDraw(int boardSize, char board[][], char blankSpace){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(board[i][j] == blankSpace){
                    return false;
                }
            }
        }
        return true;
    }
}

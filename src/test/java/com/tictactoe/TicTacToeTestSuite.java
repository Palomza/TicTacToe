package com.tictactoe;

import com.tictactoe.game.GameStateChecker;
import com.tictactoe.game.TicTacToeRunner;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

@DisplayName("TicTacToe Test Suite")
class TicTacToeTestSuite {

    @Nested
    @DisplayName("O win tests")
    class OWins {

        @Nested
        @DisplayName("Row tests")
        class OWinsInARows {

            @Test
            void testOWinsInTopRow() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[0][0] = oMark;
                board[0][1] = oMark;
                board[0][2] = oMark;

                Assertions.assertEquals(oWin, gameStateChecker.checkRows(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }

            @Test
            void testOWinsInMiddleRow() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[1][0] = oMark;
                board[1][1] = oMark;
                board[1][2] = oMark;

                Assertions.assertEquals(oWin, gameStateChecker.checkRows(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }

            @Test
            void testOWinsInBottomRow() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[2][0] = oMark;
                board[2][1] = oMark;
                board[2][2] = oMark;

                Assertions.assertEquals(oWin, gameStateChecker.checkRows(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }
        }

        @Nested
        @DisplayName("Column tests")
        class OWinsInColumns {
            @Test
            void testOWinsInTopColumn() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[0][0] = oMark;
                board[1][0] = oMark;
                board[2][0] = oMark;

                Assertions.assertEquals(oWin, gameStateChecker.checkColumns(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }

            @Test
            void testOWinsInMidColumn() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[0][1] = oMark;
                board[1][1] = oMark;
                board[2][1] = oMark;

                Assertions.assertEquals(oWin, gameStateChecker.checkColumns(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }

            @Test
            void testOWinsInBottomColumn() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[0][2] = oMark;
                board[1][2] = oMark;
                board[2][2] = oMark;

                Assertions.assertEquals(oWin, gameStateChecker.checkColumns(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }
        }

        @Nested
        @DisplayName("Diagonal tests")
        class oWinsDiagonal {
            @Test
            void testOWinsDiagonalTopRight() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[0][2] = oMark;
                board[1][1] = oMark;
                board[2][0] = oMark;

                Assertions.assertEquals(oWin, GameStateChecker.checkDiagonal(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }

            @Test
            void testOWinsDiagonalTopLeft() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[2][0] = oMark;
                board[1][1] = oMark;
                board[0][2] = oMark;

                Assertions.assertEquals(oWin, GameStateChecker.checkDiagonal(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }
        }
    }

    @Nested
    @DisplayName("X win tests")
    class XWins {

        @Nested
        @DisplayName("Row tests")
        class XWinsInRows {
            @Test
            void testXWinsInTopRow() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[0][0] = xMark;
                board[0][1] = xMark;
                board[0][2] = xMark;

                Assertions.assertEquals(xWin, GameStateChecker.checkRows(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }

            @Test
            void testXWinsInMiddleRow() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[1][0] = xMark;
                board[1][1] = xMark;
                board[1][2] = xMark;

                Assertions.assertEquals(xWin, GameStateChecker.checkRows(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }

            @Test
            void testXWinsInBottomRow() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[2][0] = xMark;
                board[2][1] = xMark;
                board[2][2] = xMark;

                Assertions.assertEquals(xWin, GameStateChecker.checkRows(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }
        }

        @Nested
        @DisplayName("Column tests")
        class XWinsInColumns {
            @Test
            void testXWinsInTopColumn() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[0][0] = xMark;
                board[1][0] = xMark;
                board[2][0] = xMark;

                Assertions.assertEquals(xWin, GameStateChecker.checkColumns(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }

            @Test
            void testXWinsInMidColumn() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[0][1] = xMark;
                board[1][1] = xMark;
                board[2][1] = xMark;

                Assertions.assertEquals(xWin, GameStateChecker.checkColumns(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }

            @Test
            void testXWinsInBottomColumn() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[0][2] = xMark;
                board[1][2] = xMark;
                board[2][2] = xMark;

                Assertions.assertEquals(xWin, GameStateChecker.checkColumns(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }
        }

        @Nested
        @DisplayName("Diagonal tests")
        class XWinsDiagonal {
            @Test
            void testXWinsDiagonalTopRight() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[0][2] = xMark;
                board[1][1] = xMark;
                board[2][0] = xMark;

                Assertions.assertEquals(xWin, GameStateChecker.checkDiagonal(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }

            @Test
            void testXWinsDiagonalTopLeft() {
                GameStateChecker gameStateChecker = new GameStateChecker();
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                int boardSize = ticTacToeRunner.getBoardSize();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                char xMark = ticTacToeRunner.getxMark();
                int oWin = ticTacToeRunner.getoWin();
                int xWin = ticTacToeRunner.getxWin();
                int noWin = ticTacToeRunner.getNoWin();
                int marksToWin = ticTacToeRunner.getMarksToWin();

                board[2][0] = xMark;
                board[1][1] = xMark;
                board[0][2] = xMark;

                Assertions.assertEquals(xWin, GameStateChecker.checkDiagonal(boardSize, board, oMark, xMark,
                        oWin, xWin, noWin, marksToWin));
            }
        }
    }

    @Nested
    @DisplayName("Draw tests")
    class NoWinSituation {
        @Test
        void testDrawSituation() {
            TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
            GameStateChecker gameStateChecker = new GameStateChecker();
            int boardSize = ticTacToeRunner.getBoardSize();
            char[][] board = ticTacToeRunner.getBoard();
            char x = ticTacToeRunner.getxMark();
            char o = ticTacToeRunner.getoMark();
            char blankSpace = ticTacToeRunner.getBlankSpace();

            board[0][0] = o;
            board[0][1] = x;
            board[0][2] = o;
            board[1][0] = x;
            board[1][1] = o;
            board[1][2] = x;
            board[2][0] = x;
            board[2][1] = o;
            board[2][2] = x;
            //  oxo
            //  xox
            //  xox

            Assertions.assertEquals(true, GameStateChecker.checkIfDraw(boardSize, board, blankSpace));

        }
        @Test
        void testNoDrawSituation() {
            TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
            GameStateChecker gameStateChecker = new GameStateChecker();
            int boardSize = ticTacToeRunner.getBoardSize();
            char[][] board = ticTacToeRunner.getBoard();
            char x = ticTacToeRunner.getxMark();
            char o = ticTacToeRunner.getoMark();
            char blankSpace = ticTacToeRunner.getBlankSpace();

            board[0][0] = o;
            board[0][1] = x;
            board[0][2] = o;
            board[1][0] = x;
            board[1][1] = o;
            board[1][2] = x;
            board[2][0] = x;
            board[2][1] = o;
            board[2][2] = blankSpace;
            //  oxo
            //  xox
            //  xob

            Assertions.assertEquals(false, gameStateChecker.checkIfDraw(boardSize, board, blankSpace));
        }
    }

    @Nested
    @DisplayName("Exception tests")
    class ExceptionTests {
        @Test
        void testIllegalArgumentException() {
            TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
            int gameMode = 20;
            String result = "tbd";

            try {

                if(ticTacToeRunner.validateGameMode(gameMode)) {
                    throw new IllegalArgumentException();
                }

            } catch (InputMismatchException e) {
                result = "Invalid Input! Please enter a number.";
            } catch (IllegalArgumentException e) {
                result = "Invalid choice! Please select 1 or 2.";
            }

            Assertions.assertEquals("Invalid choice! Please select 1 or 2.", result);
        }
        @Test
        void testInputMismatchException() {
            //tbd
            Assertions.assertEquals("Invalid Input! Please enter a number.", "tbd");
        }
    }


}

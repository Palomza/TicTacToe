package com.tictactoe;

import com.tictactoe.game.TicTacToeRunner;
import org.junit.jupiter.api.*;
import java.util.InputMismatchException;

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
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                int oWin = ticTacToeRunner.getoWin();

                board[0][0] = oMark;
                board[0][1] = oMark;
                board[0][2] = oMark;

                Assertions.assertEquals(oWin, ticTacToeRunner.checkRows());
            }

            @Test
            void testOWinsInMiddleRow() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                int oWin = ticTacToeRunner.getoWin();

                board[1][0] = oMark;
                board[1][1] = oMark;
                board[1][2] = oMark;

                Assertions.assertEquals(oWin, ticTacToeRunner.checkRows());
            }

            @Test
            void testOWinsInBottomRow() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                int oWin = ticTacToeRunner.getoWin();

                board[2][0] = oMark;
                board[2][1] = oMark;
                board[2][2] = oMark;

                Assertions.assertEquals(oWin, ticTacToeRunner.checkRows());
            }
        }

        @Nested
        @DisplayName("Column tests")
        class OWinsInColumns {
            @Test
            void testOWinsInTopColumn() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                int oWin = ticTacToeRunner.getoWin();

                board[0][0] = oMark;
                board[1][0] = oMark;
                board[2][0] = oMark;

                Assertions.assertEquals(oWin, ticTacToeRunner.checkColumns());
            }

            @Test
            void testOWinsInMidColumn() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                int oWin = ticTacToeRunner.getoWin();

                board[0][1] = oMark;
                board[1][1] = oMark;
                board[2][1] = oMark;

                Assertions.assertEquals(oWin, ticTacToeRunner.checkColumns());
            }

            @Test
            void testOWinsInBottomColumn() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                int oWin = ticTacToeRunner.getoWin();

                board[0][2] = oMark;
                board[1][2] = oMark;
                board[2][2] = oMark;

                Assertions.assertEquals(oWin, ticTacToeRunner.checkColumns());
            }
        }

        @Nested
        @DisplayName("Diagonal tests")
        class oWinsDiagonal {
            @Test
            void testOWinsDiagonalTopRight() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                int oWin = ticTacToeRunner.getoWin();

                board[0][2] = oMark;
                board[1][1] = oMark;
                board[2][0] = oMark;

                Assertions.assertEquals(oWin, ticTacToeRunner.checkDiagonal());
            }

            @Test
            void testOWinsDiagonalTopLeft() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char oMark = ticTacToeRunner.getoMark();
                int oWin = ticTacToeRunner.getoWin();

                board[2][0] = oMark;
                board[1][1] = oMark;
                board[0][2] = oMark;

                Assertions.assertEquals(oWin, ticTacToeRunner.checkDiagonal());
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
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char xMark = ticTacToeRunner.getxMark();
                int xWin = ticTacToeRunner.getxWin();

                board[0][0] = xMark;
                board[0][1] = xMark;
                board[0][2] = xMark;

                Assertions.assertEquals(xWin, ticTacToeRunner.checkRows());
            }

            @Test
            void testXWinsInMiddleRow() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char xMark = ticTacToeRunner.getxMark();
                int xWin = ticTacToeRunner.getxWin();

                board[1][0] = xMark;
                board[1][1] = xMark;
                board[1][2] = xMark;

                Assertions.assertEquals(xWin, ticTacToeRunner.checkRows());
            }

            @Test
            void testXWinsInBottomRow() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char xMark = ticTacToeRunner.getxMark();
                int xWin = ticTacToeRunner.getxWin();

                board[2][0] = xMark;
                board[2][1] = xMark;
                board[2][2] = xMark;

                Assertions.assertEquals(xWin, ticTacToeRunner.checkRows());
            }
        }

        @Nested
        @DisplayName("Column tests")
        class XWinsInColumns {
            @Test
            void testXWinsInTopColumn() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char xMark = ticTacToeRunner.getxMark();
                int xWin = ticTacToeRunner.getxWin();

                board[0][0] = xMark;
                board[1][0] = xMark;
                board[2][0] = xMark;

                Assertions.assertEquals(xWin, ticTacToeRunner.checkColumns());
            }

            @Test
            void testXWinsInMidColumn() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char xMark = ticTacToeRunner.getxMark();
                int xWin = ticTacToeRunner.getxWin();

                board[0][1] = xMark;
                board[1][1] = xMark;
                board[2][1] = xMark;

                Assertions.assertEquals(xWin, ticTacToeRunner.checkColumns());
            }

            @Test
            void testXWinsInBottomColumn() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char xMark = ticTacToeRunner.getxMark();
                int xWin = ticTacToeRunner.getxWin();

                board[0][2] = xMark;
                board[1][2] = xMark;
                board[2][2] = xMark;

                Assertions.assertEquals(xWin, ticTacToeRunner.checkColumns());
            }
        }

        @Nested
        @DisplayName("Diagonal tests")
        class XWinsDiagonal {
            @Test
            void testXWinsDiagonalTopRight() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char xMark = ticTacToeRunner.getxMark();
                int xWin = ticTacToeRunner.getxWin();

                board[0][2] = xMark;
                board[1][1] = xMark;
                board[2][0] = xMark;

                Assertions.assertEquals(xWin, ticTacToeRunner.checkDiagonal());
            }

            @Test
            void testXWinsDiagonalTopLeft() {
                TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
                char[][] board = ticTacToeRunner.getBoard();
                char xMark = ticTacToeRunner.getxMark();
                int xWin = ticTacToeRunner.getxWin();

                board[2][0] = xMark;
                board[1][1] = xMark;
                board[0][2] = xMark;

                Assertions.assertEquals(xWin, ticTacToeRunner.checkDiagonal());
            }
        }
    }

    @Nested
    @DisplayName("Draw tests")
    class NoWinSituation {
        @Test
        void testDrawSituation() {
            TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
            char[][] board = ticTacToeRunner.getBoard();
            char x = ticTacToeRunner.getxMark();
            char o = ticTacToeRunner.getoMark();

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

            Assertions.assertEquals(true, ticTacToeRunner.checkIfDraw());

        }
        @Test
        void testNoDrawSituation() {
            TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
            char[][] board = ticTacToeRunner.getBoard();
            char x = ticTacToeRunner.getxMark();
            char o = ticTacToeRunner.getoMark();
            char b = ticTacToeRunner.getBlankSpace();

            board[0][0] = o;
            board[0][1] = x;
            board[0][2] = o;
            board[1][0] = x;
            board[1][1] = o;
            board[1][2] = x;
            board[2][0] = x;
            board[2][1] = o;
            board[2][2] = b;
            //  oxo
            //  xox
            //  xob

            Assertions.assertEquals(false, ticTacToeRunner.checkIfDraw());
        }
    }

    @Nested
    @DisplayName("Exception tests")
    class ExceptionTests {
        @Test
        void testIllegalArgumentException() {
            //tbd

            Assertions.assertEquals(IllegalArgumentException.class, "tbd");
        }
        @Test
        void testInputMismatchException() {
            //tbd

            Assertions.assertEquals(InputMismatchException.class, "tbd");
        }
    }


}

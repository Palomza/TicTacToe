import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("TicTacToe Test Suite")
class TicTacToeTestSuite {

    @Nested
    @DisplayName("O win tests")
    class OWins {
        @Test
        void testOWinsInRows() {

        }

        @Test
        void testOWinsInColumns() {

        }

        @Test
        void testOWinsDiagonal() {

        }
    }

    @Nested
    @DisplayName("X win tests")
    class XWins {
        @Test
        void testXWinsInRows() {

        }

        @Test
        void testXWinsInColumns() {

        }

        @Test
        void testXWinsDiagonal() {

        }
    }

    @Test
    void testDraw(){

    }

    @Test
    void testException(){

    }

}

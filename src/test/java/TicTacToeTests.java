

import com.kodilla.Game;
import com.kodilla.WinConditions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTests {

    private char[][] board;

    @BeforeEach
    public void setUp() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }

    @Test // Napisz testy weryfikujące zwycięstwa O w wierszach.
    public void OWinsInRows() {
        char[][] board = {
                {'O', 'O', 'O'},
                {'X', 'X', ' '},
                {' ', ' ', 'X'}
        };
        assertTrue(WinConditions.checkRow(board, 'O', 3));
    }

    @Test //Napisz testy weryfikujące zwycięstwa O w kolumnach.
    public void OWinsInColumns() {
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'X', ' ', 'O'}
        };
        assertTrue(WinConditions.checkColumn(board, 'X', 3));
    }

    @Test //Napisz testy weryfikujące zwycięstwa O po przekątnych planszy.
    public void OWinsInDiagonal() {
        char[][] board = {
                {'O', 'X', 'X'},
                {'X', 'O', 'X'},
                {' ', ' ', 'O'}
        };
        assertTrue(WinConditions.checkDiagonal(board, 'O', 3));
    }

    @Test //Napisz testy weryfikujące zwycięstwa X w wierszach.

    public void XWinsInRows() {
        char[][] board = {
                {'X', 'X', 'X'},
                {'O', 'O', ' '},
                {' ', ' ', 'O'}
        };
        assertTrue(WinConditions.checkRow(board, 'X', 3));
    }
    @Test //Napisz testy weryfikujące zwycięstwa X w kolumnach
    public void XWinsInColumns() {
        char[][] board = {
                {'O', 'X', 'X'},
                {'O', 'X', 'O'},
                {' ', 'X', ' '}
        };
        assertTrue(WinConditions.checkColumn(board, 'X', 3));
    }

    @Test //Napisz testy weryfikujące zwycięstwa X po przekątnych planszy.
    public void XWinsInDiagonal() {
        char[][] board = {
                {'X', 'O', 'O'},
                {'O', 'X', 'O'},
                {' ', ' ', 'X'}
        };
        assertTrue(WinConditions.checkDiagonal(board, 'X', 3));
    }

    @Test // Napisz testy weryfikujące układy, które prowadzą do remisu.
    public void Draw() {
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };
        assertFalse(WinConditions.checkRow(board, 'X', 3));
        assertFalse(WinConditions.checkColumn(board, 'X', 3));
        assertFalse(WinConditions.checkDiagonal(board, 'X', 3));
        assertFalse(WinConditions.checkRow(board, 'O', 3));
        assertFalse(WinConditions.checkColumn(board, 'O', 3));
        assertFalse(WinConditions.checkDiagonal(board, 'O', 3));
    }
}


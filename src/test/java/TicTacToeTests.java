

import com.kodilla.Move;
import com.kodilla.WinConditions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTests {

    private char[][] board;

    @BeforeEach
    public void setUp() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }

    @Test // Napisz testy weryfikujące zwycięstwa O w wierszach.
    public void OWinsInRows() {
        // Given
        board = new char[][]{{'O', 'O', 'O'}, {'X', 'X', ' '}, {' ', ' ', 'X'}};

        // When-Then
        assertTrue(WinConditions.checkRow(board, 'O'));
    }

    @Test //Napisz testy weryfikujące zwycięstwa O w kolumnach.
    public void OWinsInColumns() {
        // Given
        board = new char[][]{{'O', 'X', 'X'}, {'O', ' ', ' '}, {'O', 'X', 'X'}};

        // When-Then
        assertTrue(WinConditions.checkColumn(board, 'O'));
    }

    @Test //Napisz testy weryfikujące zwycięstwa O po przekątnych planszy.
    public void OWinsInCross() {
        // Given
        board = new char[][]{{'O', 'X', 'X'}, {'X', 'O', ' '}, {'X', ' ', 'O'}};

        // When-Then
        assertTrue(WinConditions.checkCross(board, 'O'));
    }

    @Test //Napisz testy weryfikujące zwycięstwa X w wierszach.

    public void XWinsInRows() {
        // Given
        board = new char[][]{{'X', 'X', 'X'}, {'O', 'O', ' '}, {' ', ' ', 'O'}};

        // When-Then
        assertTrue(WinConditions.checkRow(board, 'X'));
    }

    @Test //Napisz testy weryfikujące zwycięstwa X w kolumnach
    public void XWinsInColumns() {
        // Given
        board = new char[][]{{'X', 'O', 'O'}, {'X', ' ', ' '}, {'X', 'O', 'O'}};

        // When-Then
        assertTrue(WinConditions.checkColumn(board, 'X'));
    }

    @Test //Napisz testy weryfikujące zwycięstwa X po przekątnych planszy.
    public void XWinsInCross() {
        // Given
        board = new char[][]{{'X', 'O', 'O'}, {'O', 'X', ' '}, {'O', ' ', 'X'}};

        // When-Then
        assertTrue(WinConditions.checkCross(board, 'X'));
    }

    @Test // Napisz testy weryfikujące układy, które prowadzą do remisu.
    public void Draw() {
        // Given
        board = new char[][]{{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'O', 'X', 'O'}};

        // When-Then
        assertFalse(WinConditions.checkRow(board, 'X'));
        assertFalse(WinConditions.checkColumn(board, 'X'));
        assertFalse(WinConditions.checkCross(board, 'X'));
        assertFalse(WinConditions.checkRow(board, 'O'));
        assertFalse(WinConditions.checkColumn(board, 'O'));
        assertFalse(WinConditions.checkCross(board, 'O'));
        assertTrue(BoardIsFull.isFull(board));
    }
    // Napisz testy weryfikujące, czy w przypadku błędnie wykonanych ruchów zostanie rzucony odpowiedni wyjątek.
    @Test
    public void InvalidMove() {
        // Given
        char[][] board = {{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'O', 'X', 'O'}};

        // When-Then
        assertThrows(NoSuchElementException.class, () -> Move.move(board, 'X', 2, '1'));
    }
}

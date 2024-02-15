public class BoardIsFull {
    public static boolean isFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
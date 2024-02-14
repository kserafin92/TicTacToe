package com.kodilla;

public class WinConditions {

    public static boolean checkRow(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                System.out.println("Gracz " + player + " wygrywa w rzędzie!");
                return true;
            }
        }
        return false;
    }

    public static boolean checkColumn(char[][] board, char player) {
        for (int column = 0; column < board[0].length; column++) {
            if (board[0][column] == player && board[1][column] == player && board[2][column] == player) {
                System.out.println("Gracz " + player + " wygrywa w kolumnie!");
                return true;
            }
        }
        return false;
    }

    public static boolean checkCross(char[][] board, char player) {
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            System.out.println("Gracz " + player + " wygrywa na przekątnej!");
            return true;
        }
        return false;
    }
}

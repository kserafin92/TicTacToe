package com.kodilla;

public class WinConditions {

    public static boolean checkRow(char[][] board, char player, int winCondition) {
        for (int row = 0; row < board.length; row++) {
            int count = 0;
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == player) {
                    count++;
                    if (count == winCondition) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public static boolean checkColumn(char[][] board, char player, int winCondition) {
        for (int col = 0; col < board[0].length; col++) {
            int count = 0;
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == player) {
                    count++;
                    if (count == winCondition) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonal(char[][] board, char player, int winCondition) {
        for (int row = 0; row <= board.length - winCondition; row++) {
            for (int col = 0; col <= board[row].length - winCondition; col++) {
                boolean winDiagonal1 = true;
                boolean winDiagonal2 = true;
                for (int i = 0; i < winCondition; i++) {
                    if (board[row + i][col + i] != player) {
                        winDiagonal1 = false;
                    }
                    if (board[row + i][col + winCondition - 1 - i] != player) {
                        winDiagonal2 = false;
                    }
                }
                if (winDiagonal1 || winDiagonal2) {
                    System.out.println("Gracz " + player + " wygrywa na przekątnej!");
                    return true;
                }
            }
        }
        return false;
    }
}

package com.kodilla;

public class BoardPrinter {
    public static void printBoard(char[][] board) {
        System.out.print("\t");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int row = 0; row < board.length; row++) {
            System.out.print(row + "\t");
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column] + "|\t");
            }
            System.out.println();
        }
    }
}

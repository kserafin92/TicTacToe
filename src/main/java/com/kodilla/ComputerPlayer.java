package com.kodilla;

import java.util.Random;

public class ComputerPlayer {
    private static final Random rand = new Random();

    public static void makeMove(char[][] board, char player) {
        int row, column;
        do {
            row = rand.nextInt(board.length);
            column = rand.nextInt(board[0].length);
        } while (board[row][column] != ' ');

        board[row][column] = player;
        System.out.println("Komputer (" + player + ") zajął pole: " + row + ", " + column);
    }
}

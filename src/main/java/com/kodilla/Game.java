package com.kodilla;

import java.util.Scanner;

class Game {
    public void play(char[][] board, char player) {
        while (true) {
            System.out.println(player);
            System.out.println("row");
            int row = new Scanner(System.in).nextInt();
            System.out.println("column");
            int column = new Scanner(System.in).nextInt();
            board[row][column] = player;
            BoardPrinter.printBoard(board);
            player = player == 'X' ? 'O' : 'X';
        }
    }
}


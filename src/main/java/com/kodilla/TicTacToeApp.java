package com.kodilla;



public class TicTacToeApp {
    public static void main(String[] args) {
        int size = 3;
        char[][] board = new char[size][size];

        BoardPrinter.printBoard(board);

    }
}

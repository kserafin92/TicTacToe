package com.kodilla;


import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {
        char player = 'X';

        int size = 3;
        char[][] board = new char[size][size];

        Game ticTacToeGame = new Game();

        ticTacToeGame.play(board, player);
    }
}


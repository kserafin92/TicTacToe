package com.kodilla;


import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {
        //  System.out.println("elo podaj swoj rozmiar");
        // int size = new Scanner(System.in).nextInt();
        char player = 'X';

        int size = 3;
        char[][] board = new char[size][size];

        Game ticTacToeGame = new Game();

        ticTacToeGame.play(board, player);
    }
}


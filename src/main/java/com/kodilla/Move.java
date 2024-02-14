package com.kodilla;

import java.util.Scanner;

public class Move {
    public static boolean move(char[][] board, char player) {
        System.out.println("Ruch po stronie " + player);
        System.out.println("Podaj wiersz");
        int row = new Scanner(System.in).nextInt();
        System.out.println("Podaj kolumnę");
        int column = new Scanner(System.in).nextInt();
        if (row < 0 || row >= board.length || column < 0 || column >= board[row].length) {
            System.out.println("Ruch poza planszą. Podaj poprawne współrzędne.");
            return false;
        }

        boolean correctMove = board[row][column] == 0;
        if (!correctMove) {
            System.out.println("Ruch niepoprawny. To pole jest już zajęte.");
            return false;
        }

        board[row][column] = player;
        return true;
    }
}

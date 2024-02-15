package com.kodilla;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Move {
    public static boolean move(char[][] board, char x, int i, char player) {
        System.out.println("Ruch po stronie " + player);
        System.out.println("Podaj wiersz");
        int row = new Scanner(System.in).nextInt();
        System.out.println("Podaj kolumnę");
        int column = new Scanner(System.in).nextInt();


        if (row < 0 || row >= board.length || column < 0 || column >= board[row].length) {
            throw new NoSuchElementException("Ruch poza planszą. Podaj poprawne współrzędne.");
        }

        if (board[row][column] != 0) {
            throw new NoSuchElementException("Ruch niepoprawny. To pole jest już zajęte.");
        }

        board[row][column] = player;
        return true;
    }
}

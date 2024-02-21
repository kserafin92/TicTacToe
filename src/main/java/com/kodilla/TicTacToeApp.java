package com.kodilla;



import java.util.Scanner;


public class TicTacToeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz tryb gry");
        System.out.println("1-Gra z innym graczem");
        System.out.println("2-Gra z komputerem");
        int gameMode = scanner.nextInt();


        char player = 'X';

        int size = 3;
        char[][] board = new char[size][size];

        Game ticTacToeGame = new Game();

        if (gameMode == 1) {
            ticTacToeGame.playWithHuman(board, player);
        } else if (gameMode == 2) {
            ticTacToeGame.playWithComputer(board, player);
        } else {
            System.out.println("Nieprawidłowy wybór. Zakończenie gry.");
            return;


        }
    }
}


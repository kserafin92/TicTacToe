package com.kodilla;



import java.util.Scanner;


public class TicTacToeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz tryb gry");
        System.out.println("1-Gra z innym graczem");
        System.out.println("2-Gra z komputerem");
        int gameMode = scanner.nextInt();

        System.out.println("Wybierz rozmiar planszy:");
        System.out.println("1-Standardowa plansza 3x3");
        System.out.println("2- plansza 10x10");

        int boardSizeOption = scanner.nextInt();
        int size;
        int winCondition;

        if (boardSizeOption == 2) {
            size = 10;
            winCondition = 5;
        } else {
            size = 3;
            winCondition = 3;
        }


        char player = 'X';

        char[][] board = new char[size][size];

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                board [i][j] = ' ';
            }
        }


        Game ticTacToeGame = new Game(winCondition);

        if (gameMode == 1) {
            ticTacToeGame.playWithHuman(board, player);
        } else if (gameMode == 2) {
            ticTacToeGame.playWithComputer(board, player);
        } else {
            System.out.println("Nieprawidłowy wybór. Zakończenie gry.");

        }
    }
}


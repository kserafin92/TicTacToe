package com.kodilla;

import java.util.Scanner;

public class Game {
    private final Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void playWithHuman(char[][] board, char player) {
        int movesCount = 0;
        int maxMoves = board.length * board[0].length;

        while (true) {
            BoardPrinter.printBoard(board);
            boolean correctMove = move(board, player);
            if (correctMove) {
                movesCount++;
                if (WinConditions.checkRow(board, player) || WinConditions.checkColumn(board, player) || WinConditions.checkCross(board, player)) {
                    BoardPrinter.printBoard(board);
                    System.out.println("Gracz " + player + " wygrywa!");
                    break;
                }
                if (movesCount == maxMoves) {
                    BoardPrinter.printBoard(board);
                    System.out.println("Remis!");
                    break;
                }
                player = player == 'X' ? 'O' : 'X';
            }
        }
    }

    public void playWithComputer(char[][] board, char player) {
        int movesCount = 0;
        int maxMoves = board.length * board[0].length;
        char computerPlayer = player == 'X' ? 'O' : 'X';

        while (true) {
            BoardPrinter.printBoard(board);
            if (player == 'X') {
                boolean correctMove = this.move(board, player);
                if (correctMove) movesCount++;
            } else {
                ComputerPlayer.makeMove(board, computerPlayer);
                movesCount++;
            }

            if (WinConditions.checkRow(board, player) || WinConditions.checkColumn(board, player) || WinConditions.checkCross(board, player)) {
                BoardPrinter.printBoard(board);
                System.out.println("Gracz " + player + " wygrywa!");
                break;
            }

            if (movesCount == maxMoves) {
                BoardPrinter.printBoard(board);
                System.out.println("Remis!");
                break;
            }

            if (player == 'X') {
                player = computerPlayer;
            } else {
                player = 'X';
            }
        }
    }

    private boolean move(char[][] board, char player) {
        System.out.println("Ruch gracza " + player);
        System.out.println("Podaj wiersz:");
        int row = scanner.nextInt();
        System.out.println("Podaj kolumnę:");
        int column = scanner.nextInt();

        if (row >= 0 && row < board.length && column >= 0 && column < board[0].length && board[row][column] == ' ') {
            board[row][column] = player;
            return true;
        } else {
            System.out.println("Niepoprawny ruch. Pole zajęte lub poza zakresem.");
            return false;
        }
    }
}



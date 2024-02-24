package com.kodilla;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private final int winCondition;

    public Game(int winCondition) {

        this.scanner = new Scanner(System.in);
        this.winCondition = winCondition;
    }

    public void playWithHuman(char[][] board, char player) {
        int movesCount = 0;
        int maxMoves = board.length * board[0].length;

        while (true) {
            BoardPrinter.printBoard(board);
            boolean correctMove = move(board, player);
            if (correctMove) {
                movesCount++;
                if (checkWhoWins(board, player, movesCount, maxMoves)) break;
                player = player == 'X' ? 'O' : 'X';
            }
        }
    }

    private boolean checkWhoWins(char[][] board, char player, int movesCount, int maxMoves) {
        if (WinConditions.checkRow(board, player, winCondition) ||
                WinConditions.checkColumn(board, player, winCondition) ||
                WinConditions.checkDiagonal(board, player, winCondition)) {
            BoardPrinter.printBoard(board);
            System.out.println("Gracz " + player + " wygrywa!");
            return true;
        }
        if (movesCount == maxMoves) {
            BoardPrinter.printBoard(board);
            System.out.println("Remis!");
            return true;
        }
        return false;
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

            if (checkWhoWins(board, player, movesCount, maxMoves)) break;

            if (player == 'X') {
                player = computerPlayer;
            } else {
                player = 'X';
            }
        }
    }

    private boolean move(char[][] board, char player) {
        System.out.println("Ruch gracza " + player);
        int row;
        int col;


        try {
            System.out.println("Podaj wiersz:");
            row = scanner.nextInt();
            System.out.println("Podaj kolumnę:");
            col = scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("wprowadzono nieprawidłowe dane. Spróbuj jeszcze raz");
            return false;
        }

        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == ' ') {
            throw new NoSuchElementException("Ruch niepoprawny. To pole jest już zajęte.");
        }
            board[row][col] = player;
            return true;

        }
    }




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

    public boolean move(char[][] board, char player) {
        System.out.println("Ruch gracza " + player);
        int row;
        int col;


        try {
            System.out.println("Podaj wiersz i kolumnę oddzielone przecinkiem:");
            String line = scanner.nextLine(); //0,1
            String[] splitValues = line.split(",");

            if(splitValues.length !=2) {
                throw new IllegalArgumentException();
            }

            row = Integer.parseInt(splitValues[0].trim());
            col = Integer.parseInt(splitValues[1].trim());

        } catch(Exception e) {
            System.out.println("wprowadzono nieprawidłowe dane. Spróbuj jeszcze raz");
            scanner.nextLine();
            return move(board, player);
        }

        if (IsAlreadyTaken(board, row, col)) {
            System.out.println("Ruch niepoprawny. To pole jest już zajęte.");
            return move(board, player);
        }
        if(isOutOfBounds(board, row, col)){
            System.out.println("Wartość nie powinna wykraczać powyżej " + (board.length-1));
            return move(board, player);
        }
            board[row][col] = player;
            return true;

        }

    private boolean isOutOfBounds(char[][] board, int row, int col) {
        return row >= board.length || col >= board.length;
    }

    private boolean IsAlreadyTaken(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] != ' ';
    }
}




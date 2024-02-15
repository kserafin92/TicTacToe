package com.kodilla;

import static com.kodilla.Move.move;

class Game {
    public void play(char[][] board, char player) {
        int movesCount = 0;
        int maxMoves = board.length* board[0].length;

        while (true) {
            BoardPrinter.printBoard(board);
            boolean correctMove = move(board, 'X', 2, player);
            if (correctMove) {
                movesCount++;

                if (WinConditions.checkRow(board, player) || WinConditions.checkColumn(board, player) || WinConditions.checkCross(board, player)) {
                    BoardPrinter.printBoard(board);
                    System.out.println("Gracz " + player + " wygrywa!");
                    break;
                }
                if (movesCount == maxMoves){
                    BoardPrinter.printBoard(board);
                    System.out.println("Remis!");
                    break;
                }
                player = player == 'X' ? 'O' : 'X';
            }
        }
    }
}

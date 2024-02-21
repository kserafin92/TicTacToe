package com.kodilla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComputerPlayer {
    private static final Random rand = new Random();

    public static void makeMove(char[][] board, char player) {
        List<Coordinate> possibleCooridinaters = new ArrayList<>();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (board[x][y] == ' ') {
                    possibleCooridinaters.add(new Coordinate(x, y));
                }
            }
        }
        Collections.shuffle(possibleCooridinaters);

        Coordinate newMoveCoordinate = possibleCooridinaters.getFirst();

        board[newMoveCoordinate.x][newMoveCoordinate.y] = player;
        System.out.println("Komputer (" + player + ") zajął pole:" + newMoveCoordinate.x + "," + newMoveCoordinate.y);
    }

    private record Coordinate(int x, int y) {
    }
}
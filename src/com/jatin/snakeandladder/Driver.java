package com.jatin.snakeandladder;

import com.jatin.snakeandladder.Ladder;
import com.jatin.snakeandladder.Player;
import com.jatin.snakeandladder.Snake;
import com.jatin.snakeandladder.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for(int i=0 ; i<noOfSnakes ; i++){
            snakes.add(new Snake(scanner.nextInt(),scanner.nextInt()));
        }

        int noOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<Ladder>();
        for (int i = 0; i < noOfLadders; i++) {
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }

        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(scanner.next()));
        }

         SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
         snakeAndLadderService.setLadders(ladders);
         snakeAndLadderService.setSnakes(snakes);
         snakeAndLadderService.setPlayers(players);

         snakeAndLadderService.startGame();

    }
}

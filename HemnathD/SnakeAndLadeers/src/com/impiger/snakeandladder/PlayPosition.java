package com.impiger.snakeandladder;
import java.util.*;
 class DiceService {
    public static int roll() {
        return new Random().nextInt(6) + 1; 
}
 }
public class PlayPosition {
	
	private Board Board;
    private int NumberOfPlayers;
    private Queue<Player> players; 
    private static final int boardsize = 100; //The board will have 100 cells numbered from 1 to 100.
    public PlayPosition(int boardSize) {
        this.Board = new Board(boardSize);  //Optional Rule 2
        this.players = new LinkedList<Player>();
    }

    public PlayPosition() {
        this(PlayPosition.boardsize);
    }
    public void setNoOfDices(int noOfDices) {
    }

    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<Player>();
        this.NumberOfPlayers = players.size();
        Map<String, Integer> playerPieces = new HashMap<String, Integer>();
        for (Player player : players) {
            this.players.add(player);
          //Each player has a coin which is initially kept outside the board (i.e., at position 0).
            playerPieces.put(player.getId(), 0); 
        }
    //  Add pieces to board
        Board.setPlayercoin(playerPieces); 
    }
    // Add snakes to board
    public void setSnakes(List<Snake> snakes) {
    	Board.setSnake(snakes);
    }
 // Add ladders to board
    public void setLadders(List<Ladder> ladders) {
    	Board.setLadders(ladders); 
    }

    private int getNewPosition(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Snake snake : Board.getSnake()) {
                if (snake.getStart() == newPosition) {
                	//staring and ending position of the sanke
                    newPosition = snake.getEnd(); 
                }
            }

            for (Ladder ladder : Board.getLadders()) {
                if (ladder.getStart() == newPosition) {
                	//staring and ending position of the ladder
                    newPosition = ladder.getEnd(); 
                }
            }
        } while (newPosition != previousPosition); //ending should not connect with previos position
        return newPosition;
    }

    private void movePlayer(Player player, int positions) {
        int oldPosition = Board.getPlayercoin().get(player.getId());
        //player moving position
        int newPosition = oldPosition + positions; 

        int boardSize = Board.getSize();

        if (newPosition > boardSize) {
            newPosition = oldPosition;
        } else {
            newPosition = getNewPosition(newPosition);
        }

        Board.getPlayercoin().put(player.getId(), newPosition);

        System.out.println(player.getName() + " rolled a " + positions + " and moved from " + oldPosition +" to " + newPosition);
    }

    private boolean hasPlayerWon(Player player) {
        int playerPosition = Board.getPlayercoin().get(player.getId());
        int winningPosition = Board.getSize();
     // A player wins reaches the position 100 and the game ends there.
        return playerPosition == winningPosition; 
    }

    private boolean isGameCompleted() {
        int currentNumberOfPlayers = players.size();
        return currentNumberOfPlayers < NumberOfPlayers;
    }

    public void startGame() {
        while (!isGameCompleted()) {
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer, NumberOfPlayers);
            if (hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins the game");
                Board.getPlayercoin().remove(currentPlayer.getId());
            } else {
                players.add(currentPlayer);
            }
        }
    }
}

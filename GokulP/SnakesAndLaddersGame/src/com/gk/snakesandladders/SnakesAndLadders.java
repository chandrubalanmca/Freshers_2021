package com.gk.snakesandladders;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakesAndLadders {
	Map<Integer, Integer> playerPosition=new HashMap<>();
    Board board=new Board();
    Random rand=new Random();
    int noOfPlayers;
	public void setPlayers(int playerCount) {
		this.noOfPlayers=playerCount;
		for(int index=1;index<=playerCount;index++) {
			playerPosition.put(index,0);	
		}
	}
	
	public String playGame() {
		int playerNo=1,dice,position;
		while(true) {
			dice=rand.nextInt(6);
			if(dice==0)continue;
			position=playerPosition.get(playerNo)+dice;
			if(position==100) {
				return "Player "+playerNo+" has won the game";
			}
			else if(position<100) {
				if(board.snakesAndLaddersPosition.containsKey(position)) {
					System.out.println("Player"+playerNo+ " got snake or ladder "+playerPosition.get(playerNo));
					position=board.snakesAndLaddersPosition.get(position);
				}
				playerPosition.put(playerNo,position);
			}
			System.out.println("Player"+playerNo+ "was moved to position "+playerPosition.get(playerNo));
			if(dice==6) {
				continue;
			}
			playerNo=(playerNo>=noOfPlayers)?1:playerNo+1;
			
		}		
	}
	public void generateRandomSnakesAndLadders(int ladderPercent, int snakePercent) {
		board.snakesAndLaddersPosition(ladderPercent,snakePercent);
		
	}


	public void boardRepresentation() {
		board.view();
		
	}
	

	
	

}

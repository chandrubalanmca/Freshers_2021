package com.gk.snakesandladders;

import java.util.Scanner;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of Players");
		int playerCount=sc.nextInt();
		try {
		if(playerCount>4) {
			throw new Exception("Enter Valid Player Count\nPlayer count must be less than 4");
		}
		SnakesAndLadders newGame=new SnakesAndLadders();
		newGame.setPlayers(playerCount);
		System.out.println("Enter Ladder Percent");
		int ladderPercent=sc.nextInt();
		System.out.println("Enter Snake Percent");
		int snakePercent=sc.nextInt();
		if(ladderPercent >40 || ladderPercent<2 || snakePercent >40 
				|| snakePercent <2 || snakePercent+ladderPercent>40 ){
			throw new Exception("Enter Valid Percentage\nPercentage Must be greater than 1 and less than 40 ");
		}
		newGame.generateRandomSnakesAndLadders(ladderPercent,snakePercent);
		System.out.println(newGame.playGame());
		newGame.boardRepresentation();
		sc.close();
		
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

}
}

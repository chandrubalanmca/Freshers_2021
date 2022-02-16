package Main;
import java.util.*;

import Service.SnakeAndLadderService;
import snakeandladdder.Player;


public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer> snakes = new HashMap<>();
        Map<Integer, Integer> ladders = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of snakes");
        int noOfSnakes = sc.nextInt();
        for(int i=0;i<noOfSnakes;i++) {
            System.out.println("Enter snake's head and tail positions");
            int start = sc.nextInt();
            int end = sc.nextInt();
            snakes.put(start,end);
        }
        System.out.println("Enter number of ladders");
        int noOfLadders = sc.nextInt();
        for(int i=0;i<noOfLadders;i++) {
            System.out.println("Enter ladder's start and end positions");
            int start = sc.nextInt();
            int end = sc.nextInt();
            ladders.put(start,end);
        }

        System.out.println("Enter the number of players");
        int noOfPlayers = sc.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i=0;i<noOfPlayers;i++) {
            players.add(new Player(sc.next()));
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService(ladders, snakes, players);
        snakeAndLadderService.startGame();

    }
}



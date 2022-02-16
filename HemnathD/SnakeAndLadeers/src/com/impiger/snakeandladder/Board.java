package com.impiger.snakeandladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
	private int size;
	private List<Snake> snake;
	private List<Ladder> ladders;
	private Map<String, Integer>playercoin;
	


	public Board(int size) {
		super();
		this.size = size;
		this.snake = new ArrayList<Snake>();
		this.ladders = new ArrayList<Ladder>();
		this.playercoin = new HashMap<String, Integer>();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Snake> getSnake() {
		return snake;
	}

	public void setSnake(List<Snake> snake) {
		this.snake = snake;
	}

	public List<Ladder> getLadders() {
		return ladders;
	}

	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}

	public Map<String, Integer> getPlayercoin() {
		return playercoin;
	}

	public void setPlayercoin(Map<String, Integer> playercoin) {
		this.playercoin = playercoin;
	}
	
}

package com.task.rubikscube;

import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();

		RubiksCube rubiksCube = new RubiksCube();
		rubiksCube.setRotation(userInput);
		rubiksCube.rotateTilesPosition();
		rubiksCube.printTiles();
		scanner.close();
	}
}

package com.task.rubikscube;

import java.util.ArrayList;
import java.util.List;

public class RubiksCube {
	private final String[] rubiksColour = { "White", "Yellow", "Red", "Orange", "Blue", "Green" };
	private final String[] rubiksSide= {"FRONT","BACK","RIGHT","LEFT","TOP","BOTTOM"};
	int[][][] rubiksCube = new int[6][3][3];
	
	CubeRotation rotate=new CubeRotation();
	
    protected List<String> rotations = new ArrayList<>();

	public RubiksCube() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				for(int k=0;k<3;k++)
				rubiksCube[i][j][k] = i;
			}
		}
	}
	
	

	public void setRotation(String userInput) {
		String rotation;
		for (int i = 0; i < userInput.length(); i++) {
			if (!Character.isAlphabetic(userInput.charAt(i))) {
				rotation = new StringBuilder().append(userInput.charAt(i)).append(userInput.charAt(i + 1)).toString().toUpperCase();
				rotations.add(rotation);
				i++;
			} else {
				rotations.add(Character.toString(userInput.charAt(i)).toUpperCase());
			}
		}
		//System.out.println(rotations);
	}

	
	
	public void rotateTilesPosition() {
		int index = 0;
		while (index < rotations.size()) {
			switch(rotations.get(index)) {
			case "U":
			case "D":
				rotate.topAndBottomRotate(rubiksCube,true);
				break;
				
			case "-U":
			case "-D":
				rotate.topAndBottomRotate(rubiksCube,false);
				break;
				
			case "F":
			case "B":
				rotate.frontAndBackRotate(rubiksCube,true);
				break;
			
			case "-F":
			case "-B":
				rotate.frontAndBackRotate(rubiksCube, false);
				break;
			
			case "R":
			case "L":
				rotate.rightAndLeftRotate(rubiksCube, true);
				break;
				
			case "-R":
			case "-L":
				rotate.rightAndLeftRotate(rubiksCube, false);
				break;
				
			default:
				System.out.println("Invalid Input:"+rotations.get(index)+"\n");
				break;			
			}
			index++;
		}
	}
	
	
	
	//printing Front Tiles
	public void printTiles() {
		for(int sides=0;sides<6;sides++) {
			System.out.println(rubiksSide[sides]+" SIDE TILES:\n");
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				System.out.print(rubiksColour[rubiksCube[sides][row][col]]+"  ");
			}
			System.out.println("\n");
		}
		System.out.println("*********************\n");
	}
	}



}

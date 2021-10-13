package com.task.rubikscube;

public class CubeRotation {
	private final int front = 0;
	private final int back = 1;
	private final int right = 2;
	private final int left = 3;
	private final int top = 4;
	private final int bottom = 5;
	int[][] tempArray = new int[3][3];

	public void topAndBottomRotate(int[][][] rubiksCube, boolean isClockwise) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				tempArray[row][col] = rubiksCube[top][row][col];
			}
		}
		if (isClockwise) {
			rotate(front, rubiksCube);
			rotate(bottom, rubiksCube);
			rotate(back, rubiksCube);
			rotate(top, rubiksCube);
		} else {
			rotate(back, rubiksCube);
			rotate(bottom, rubiksCube);
			rotate(front, rubiksCube);
			rotate(top, rubiksCube);
		}
	}
	
	
	public void frontAndBackRotate(int[][][] rubiksCube, boolean isClockwise) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				tempArray[row][col] = rubiksCube[front][row][col];
			}
		}
		if (isClockwise) {
			rotate(right, rubiksCube);
			rotate(back, rubiksCube);
			rotate(left, rubiksCube);
			rotate(front, rubiksCube);
		} else {
			rotate(left, rubiksCube);
			rotate(back, rubiksCube);
			rotate(right, rubiksCube);
			rotate(front, rubiksCube);
		}
	}
	
	public void rightAndLeftRotate(int[][][] rubiksCube, boolean isClockwise) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				tempArray[row][col] = rubiksCube[right][row][col];
			}
		}
		if (isClockwise) {
			rotate(bottom, rubiksCube);
			rotate(left, rubiksCube);
			rotate(top, rubiksCube);
			rotate(right, rubiksCube);
		} else {
			rotate(top, rubiksCube);
			rotate(left, rubiksCube);
			rotate(bottom, rubiksCube);
			rotate(right, rubiksCube);
		}
	}

	
	
	public void rotate(int sideTo, int[][][] rubiksCube) {
		int temp;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				temp = rubiksCube[sideTo][row][col];
				rubiksCube[sideTo][row][col] = tempArray[row][col];
				tempArray[row][col] = temp;
			}
		}
	}

	public void topAntiClockWiseRotate(int[][][] rubiksCube) {

	}

}

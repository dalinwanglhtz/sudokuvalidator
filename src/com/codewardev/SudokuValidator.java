package com.codewardev;

//https://www.codewars.com/kata/529bf0e9bdf7657179000008/train/java

import java.util.Arrays;

public class SudokuValidator {

	public static boolean check(int[][] sudoku) {
		int[][] xSquare = new int[9][9];
		int[][] hSquare = new int[9][9];
		int[] counter = new int[9];
		Arrays.fill(counter, 0);

 		for(int i=0; i<sudoku.length; i++) {
			for(int j=0; j<sudoku[i].length; j++) {
				if(sudoku[i][j] == 0) {
					return false;
				}
				hSquare[j][i] = sudoku[i][j];
				if(i<3 && j<3) {
					System.out.println("top left: "+sudoku[i][j]);
					xSquare[0][counter[0]++] = sudoku[i][j];
				} else
				if(i<3 && j>=3 && j<6) {
					System.out.println("top middle: "+sudoku[i][j]);
					xSquare[1][counter[1]++] = sudoku[i][j];
				} else
				if(i<3 && j>=6) {
					System.out.println("top right: "+sudoku[i][j]);
					xSquare[2][counter[2]++] = sudoku[i][j];
				} else
				if(i>=3 && i<6 && j<3) {
					System.out.println("middle left: "+sudoku[i][j]);
					xSquare[3][counter[3]++] = sudoku[i][j];
				} else
				if(i>=3 && i<6 && j>=3 && j<6) {
					System.out.println("middle middle: "+sudoku[i][j]);
					xSquare[4][counter[4]++] = sudoku[i][j];
				} else
				if(i>=3 && i<6 && j>=6) {
					System.out.println("middle right: "+sudoku[i][j]);
					xSquare[5][counter[5]++] = sudoku[i][j];
				} else
				if(i>=6 && j<3) {
					System.out.println("bottom left: "+sudoku[i][j]);
					xSquare[6][counter[6]++] = sudoku[i][j];
				} else
				if(i>=6 && j>=3 && j<6) {
					System.out.println("bottom middle: "+sudoku[i][j]);
					xSquare[7][counter[7]++] = sudoku[i][j];
				} else
				if(i>=6 && j>=6) {
					System.out.println("bottom right: "+sudoku[i][j]);
					xSquare[8][counter[8]++] = sudoku[i][j];
				}
			}
		}
		
		
		return isAllDistinct(sudoku) && isAllDistinct(xSquare) && isAllDistinct(hSquare) ? true : false;
	}

	private static boolean isAllDistinct(int[][] grid) {
		for(int i=0; i<grid.length; i++) {
			if(Arrays.stream(grid[i]).distinct().count() != 9) return false;
		}
		return true;
	}

	private static void printGrid(int[][] square) {
		System.out.println("Square:");
		for(int i=0; i<square.length; i++) {
			for(int j=0; j<square[i].length; j++) {
				System.out.print(square[i][j]+" ");
			}
			System.out.println();
		}
	}

}

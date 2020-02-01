package com.codewardev;

//https://www.codewars.com/kata/529bf0e9bdf7657179000008/train/java

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
				
				fillXSquare(i, j, xSquare, sudoku, counter);
			}
		}
		
		
		return isAllDistinct(sudoku) && isAllDistinct(xSquare) && isAllDistinct(hSquare) ? true : false;
	}

	private static void fillXSquare(int i, int j, int[][] xSquare, int[][] sudoku, int[] counter) {
		int count = OpsFactory.getOps(i, j);
		if(count != -1) {
			xSquare[count][counter[count]++] = sudoku[i][j];
		}
	}

	private static boolean isAllDistinct(int[][] grid) {
		for(int i=0; i<grid.length; i++) {
			if(Arrays.stream(grid[i]).distinct().count() != 9) return false;
		}
		return true;
	}

}


class OpsFactory{
	static Map<Integer, XSquareOps> opsMap = new HashMap<>();
	static {
		opsMap.put(0, new Zero());
		opsMap.put(1, new One());
		opsMap.put(2, new Two());
		opsMap.put(3, new Three());
		opsMap.put(4, new Four());
		opsMap.put(5, new Five());
		opsMap.put(6, new Six());
		opsMap.put(7, new Seven());
		opsMap.put(8, new Eight());
	}
	
	public static int getOps(int i, int j){
		for(Map.Entry<Integer, XSquareOps> a: opsMap.entrySet()) {
			XSquareOps op = a.getValue();
			if(op.isMet(i, j)) {
				return a.getKey();
			}
		}
		return -1;
	}
}

interface XSquareOps{
	boolean isMet(int i, int j);
}

class Zero implements XSquareOps{

	@Override
	public boolean isMet(int i, int j) {
		if(i<3 && j<3) return true;
		return false;
	}
	
}

class One implements XSquareOps{

	@Override
	public boolean isMet(int i, int j) {
		if(i<3 && j>=3 && j<6) return true;
		return false;
	}
	
}

class Two implements XSquareOps{

	@Override
	public boolean isMet(int i, int j) {
		if(i<3 && j>=6) return true;
		return false;
	}
	
}

class Three implements XSquareOps{

	@Override
	public boolean isMet(int i, int j) {
		if(i>=3 && i<6 && j<3) return true;
		return false;
	}
	
}

class Four implements XSquareOps{

	@Override
	public boolean isMet(int i, int j) {
		if(i>=3 && i<6 && j>=3 && j<6) return true;
		return false;
	}
	
}

class Five implements XSquareOps{

	@Override
	public boolean isMet(int i, int j) {
		if(i>=3 && i<6 && j>=6) return true;
		return false;
	}
	
}

class Six implements XSquareOps{

	@Override
	public boolean isMet(int i, int j) {
		if(i>=6 && j<3) return true;
		return false;
	}
	
}

class Seven implements XSquareOps{

	@Override
	public boolean isMet(int i, int j) {
		if(i>=6 && j>=3 && j<6) return true;
		return false;
	}
	
}

class Eight implements XSquareOps{

	@Override
	public boolean isMet(int i, int j) {
		if(i>=6 && j>=6) return true;
		return false;
	}
	
}
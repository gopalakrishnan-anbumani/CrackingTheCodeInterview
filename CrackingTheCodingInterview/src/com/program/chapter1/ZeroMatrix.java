/**
 * 07-May-2018
 */
package com.program.chapter1;

import java.util.Arrays;
// I had idea that we can make row and col -1 if zero present. After we can change -1 to 0
public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] mat = {{0,5,3,7},{6,2,9,9},{5,3,8,0}};
		effectiveMethod(mat);
	}
	
	//Effective Approach O(1) space;
	public static void effectiveMethod(int[][] matrix){
		
		boolean rowOneHasZero = false;
		boolean colOneHasZero = false;
		
		int row = matrix.length;
		int col = matrix[0].length;
		for(int i=0;i<col;i++){
			if(matrix[0][i]==0){
				rowOneHasZero=true;
				break;
			}
		}
		for(int i=0;i<row;i++){
			if(matrix[i][0]==0){
				colOneHasZero=true;
				break;
			}
		}
		
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				if(matrix[i][j]==0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i=1;i<col;i++){
			if(matrix[0][i]==0){
				nullifyCol(matrix,i);
			}
		}
		for(int i=1;i<row;i++){
			if(matrix[i][0]==0){
				nullifyRow(matrix,i);
			}
		}
		if(rowOneHasZero) nullifyRow(matrix, 0);
		if(colOneHasZero) nullifyCol(matrix, 0);
		printMatrix(matrix);
		
	}
	public static void nullifyRow(int[][] matrix,int row){
		
		for(int a=0;a<matrix.length;a++){
			matrix[row][a] = 0;
		}
		
	}
	public static void nullifyCol(int[][] matrix,int col){
		
		for(int a=0;a<matrix.length;a++){
			matrix[a][col] = 0;
		}
		
	}
	//Normal Method Didn't consider Space, Memory
	// Make the Entire Row and Col Zero If Matrix of M,N = 0
	public static void normalMethod(int[][] matrix){
		int r = matrix.length;
		int c = matrix[0].length;
		String zeros = "";	
		for(int i =0 ;i<r;i++){
			for(int j=0;j<c;j++){
				if(matrix[i][j]==0){
					zeros+="("+i+","+j+")";
				}
			}
		}
		// It'll Split (X,X) 
		for(int i=0;i<zeros.length();i+=5){
			int start = i;
			int end = i+4;
			int R = Character.getNumericValue(zeros.charAt(start+1)); 
			int C = Character.getNumericValue(zeros.charAt(end-1));
			for(int allCol=0;allCol<c;allCol++){
				matrix[R][allCol]=0;
			}
			for(int allRow=0;allRow<r;allRow++){
				matrix[allRow][C]=0;
			}
			
		}
		
	}
	
	public static void printMatrix(int[][] matrix){
		int r = matrix.length;
		int c = matrix[0].length;
				//Print
				for(int i =0 ;i<r;i++){
					for(int j=0;j<c;j++){
						System.out.print(matrix[i][j]+" ");
					}
					System.out.println();
				}
	}
}




/*
Input : int[][] mat = {{1,0,3},{6,2,3},{5,3,8}};
Ourput :
0 0 0 
6 0 3 
5 0 8 

int[][] mat = {{1,5,3,7},{6,2,3,9},{5,3,8,0}};
1 5 3 0 
6 2 3 0 
0 0 0 0 
*/
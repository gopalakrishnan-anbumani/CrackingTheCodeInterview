/**
 * 07-May-2018
 */
package com.program.chapter1;

import java.util.Arrays;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] mat = {{1,5,3,7},{6,2,3,9},{5,3,8,0}};
		normalMethod(mat);
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
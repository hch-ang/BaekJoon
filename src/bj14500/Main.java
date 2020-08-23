package bj14500;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int M;
	static int[][] arr;
	static int max = 0;
	static int[][][] filter = {{{1, 1, 1, 1}},
			{{1, 1}, {1, 1}},
			{{1, 0, 0}, {1, 1, 1}},
			{{0, 0, 1}, {1, 1, 1}},
			{{1, 1, 1}, {1, 0, 0}},
			{{1, 1, 1}, {0, 0, 1}},
			{{1, 1, 0}, {0, 1, 1}},
			{{0, 1, 1}, {1, 1, 0}},
			{{1, 1, 1}, {0, 1, 0}},
			{{0, 1, 0}, {1, 1, 1}},
			{{1, 0}, {1, 0}, {1, 1}},
			{{0, 1}, {0, 1}, {1, 1}},
			{{1, 1}, {1, 0}, {1, 0}},
			{{1, 1}, {0, 1}, {0, 1}},
			{{1, 0}, {1, 1}, {0, 1}},
			{{0, 1}, {1, 1}, {1, 0}},
			{{0, 1}, {1, 1}, {0, 1}},
			{{1, 0}, {1, 1}, {1, 0}},
			{{1}, {1}, {1}, {1}}
			};
	
	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][];
		for(int i = 0; i < N; i++) {
			arr[i] = new int[M];
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				check(i, j);
			}
		}
		
		System.out.println(max);
	}
	
	static void check(int I, int J) {
		if(J + 3 < M)
			convolution(I, J, 0);
		if(I + 1 < N) {
			if(J + 1 < M)
				convolution(I, J, 1);
			if(J + 2 < M) {
				convolution(I, J, 2);
				convolution(I, J, 3);
				convolution(I, J, 4);
				convolution(I, J, 5);
				convolution(I, J, 6);
				convolution(I, J, 7);
				convolution(I, J, 8);
				convolution(I, J, 9);
			}
		}
		if(I + 2 < N) {
			if(J + 1 < M) {
				convolution(I, J, 10);
				convolution(I, J, 11);
				convolution(I, J, 12);
				convolution(I, J, 13);
				convolution(I, J, 14);
				convolution(I, J, 15);
				convolution(I, J, 16);
				convolution(I, J, 17);
			}
		}
		if(I + 3 < N)
			convolution(I, J, 18);
	}
	
	static void convolution(int I, int J, int filterNum) {
		int tempsum = 0;
		for(int i = 0; i < filter[filterNum].length; i++) {
			for(int j = 0; j < filter[filterNum][i].length; j++)
				tempsum += filter[filterNum][i][j] * arr[I+i][J+j];
		}
		max = max > tempsum ? max : tempsum;
	}
}

package bj2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = new int[9][9];
	static boolean[][] rows = new boolean[9][10];
	static boolean[][] cols = new boolean[9][10];
	static boolean[][][] squares = new boolean[3][3][10];
	static int LIMIT;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int temp;
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 9; j++) {
				temp = Integer.parseInt(st.nextToken());
				if(temp == 0)
					LIMIT++;
				arr[i][j] = temp;
				rows[i][temp] = true;
				cols[j][temp] = true;
				squares[i/3][j/3][temp] = true;
			}
		}
		bfs(-1, 8, 0);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			sb.append(arr[i][0]);
			for(int j = 1; j < 9; j++)
				sb.append(" ").append(arr[i][j]);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static boolean bfs(int I, int J, int count) {
		if(count == LIMIT)
			return true;
		for(int j = J+1; j < 9; j++) {
			if(arr[I][j] == 0) {
				for(int num = 1; num <= 9; num++) {
					if(rows[I][num] || cols[j][num] || squares[I/3][j/3][num])
						continue;
					arr[I][j] = num;
					rows[I][num] = true;
					cols[j][num] = true;
					squares[I/3][j/3][num] = true;
					if(bfs(I, j, count+1))
						return true;
					arr[I][j] = 0;
					rows[I][num] = false;
					cols[j][num] = false;
					squares[I/3][j/3][num] = false;
				}
				return false;
			}
		}
		for(int i = I+1; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(arr[i][j] == 0) {
					for(int num = 1; num <= 9; num++) {
						if(rows[i][num] || cols[j][num] || squares[i/3][j/3][num])
							continue;
						arr[i][j] = num;
						rows[i][num] = true;
						cols[j][num] = true;
						squares[i/3][j/3][num] = true;
						if(bfs(i, j, count+1))
							return true;
						arr[i][j] = 0;
						rows[i][num] = false;
						cols[j][num] = false;
						squares[i/3][j/3][num] = false;
					}
					return false;
				}
			}
		}
		
		//Tresh
		return true;
	}
}

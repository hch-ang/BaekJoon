package bj17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int res;
	static int[][] arr;
	static int[] order;
	static boolean[] sig;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][9];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 9; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		order = new int[9];
		order[3] = 0;
		sig = new boolean[9];
		sig[0] = true;
		res = 0;
		comb(0);
		System.out.println(res);
	}
	
	static void simul() {
		
//		for(int i = 0; i < 9; i++) {
//			System.out.print(order[i] + " ");
//		}
//		System.out.println();
		
		int result = 0;
		int out = 0;
		int n = 0;
		int index = 0;
		boolean[] ru = new boolean[4];
		while(n < N) {
			switch(arr[n][order[index]]) {
			case 0:
				out++;
				if(out == 3) {
					ru[1] = false;
					ru[2] = false;
					ru[3] = false;				
					out = 0;
					n++;
				}
				break;
			case 1:
				result += ru[3] ? 1 : 0;
				ru[3] = ru[2];
				ru[2] = ru[1];
				ru[1] = true;
				break;
			case 2:
				result += ru[3] ? 1 : 0;
				result += ru[2] ? 1 : 0;
				ru[3] = ru[1];
				ru[2] = true;
				ru[1] = false;
				break;
			case 3:
				result += ru[3] ? 1 : 0;
				result += ru[2] ? 1 : 0;				
				result += ru[1] ? 1 : 0;
				ru[3] = true;
				ru[2] = false;
				ru[1] = false;
				break;
			case 4:
				result += ru[3] ? 1 : 0;
				result += ru[2] ? 1 : 0;				
				result += ru[1] ? 1 : 0;
				result++;
				ru[3] = false;
				ru[2] = false;
				ru[1] = false;
				break;
			}
			index = (index + 1)%9;
		}
		res = res > result ? res : result;
	}
	
	static void comb(int iteration) {
		if(iteration == 9) {
			simul();
			return;
		}
		if(iteration == 3)
			comb(iteration + 1);
		else {
			for(int i = 1; i < 9; i++) {
				if(!sig[i]) {
					sig[i] = true;
					order[iteration] = i;
					comb(iteration + 1);
					sig[i] = false;
				}
			}
		}
	}
}

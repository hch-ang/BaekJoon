package bj14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] arr;
	static int[] ops = new int[4];
	static int max = -100000000;
	static int min = 100000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < 4; i++)
			ops[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < 4; i++) {
			if(ops[i] >= N)
				ops[i] = N-1;
		}
		
		for(int i = 0; i < 4; i++) {
			if(ops[i] > 0) {
				ops[i]--;
				recur(2, calc(arr[0], arr[1], i));
				ops[i]++;
			}
		}
		System.out.println(max);
		System.out.println(min);
	}
	
	static void recur(int iteration, int res) {
		if(iteration == N) {
			max = max > res ? max : res;
			min = min < res ? min : res;
			return;
		}
				
		for(int i = 0; i < 4; i++)
			if(ops[i] > 0) {
				ops[i]--;
				recur(iteration + 1, calc(res, arr[iteration], i));
				ops[i]++;
			}
	}
	
	static int calc(int num1, int num2, int op) {
		int res;
		switch(op) {
		case 0:
			res =  num1 + num2;
			break;
		case 1:
			res =  num1 - num2;
			break;
		case 2:
			res =  num1 * num2;
			break;
		default:
			res =  num1 / num2;
			break;
		}
		return res;
	}
}

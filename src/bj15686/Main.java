package bj15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[][] arr;
	static int[] hr;
	static int[] hc;
	static int hcount;
	static int[] cr;
	static int[] cc;
	static int ccount;
	static boolean[] csig;
	static int min = 1300;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		hr = new int[2*N];
		hc = new int[2*N];
		cr = new int[13];
		cc = new int[13];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					hr[hcount] = i;
					hc[hcount++] = j;
				}
				else if(arr[i][j] == 2) {
					cr[ccount] = i;
					cc[ccount++] = j;
				}
			}
		}
		csig = new boolean[ccount];
		if(ccount == M) {
			for(int i = 0; i < ccount; i++)
				csig[i] = true;
			calc();
			System.out.println(min);
			return;
		}
			
		for(int i = 0; i <= ccount-M; i++) {
			csig[i] = true;
			recur(i, 1);
			csig[i] = false;
		}
		
		System.out.println(min);
		return;		
	}
	
	static void recur(int index, int iterative) {
		if(iterative == M) {
			calc();
			return;
		}
		for(int i = index + 1; i <= ccount - M + iterative; i++) {
			csig[i] = true;
			recur(i, iterative + 1);
			csig[i] = false;
		}
	}
	
	static void calc() {
//		for(int i = 0; i < ccount; i++) {
//			if(csig[i])
//				System.out.print(1 + " ");
//			else
//				System.out.print(0 + " ");
//		}
//		System.out.println();
		int tempsum = 0;
		for(int i = 0; i < hcount; i++) {
			int tempmin = 100;
			for(int j = 0; j < ccount; j++) {
				if(csig[j] == true) {
					int dist = 0;
					dist += hr[i] > cr[j] ? hr[i] - cr[j] : cr[j] - hr[i];
					dist += hc[i] > cc[j] ? hc[i] - cc[j] : cc[j] - hc[i];
					tempmin = tempmin < dist ? tempmin : dist;
				}
			}
			tempsum += tempmin;
		}
//		System.out.println(tempsum);
		min = min < tempsum ? min : tempsum;
	}
}

package bj14696;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int a, b, numa, numb, res;
		int[] A = new int[5];
		int[] B = new int[5];
		for(int i = 0; i < N; i++) {
			for(int j = 1; j <= 4; j++) {
				A[j] = 0;
				B[j] = 0;
			}
			st = new StringTokenizer(in.readLine());
			numa = Integer.parseInt(st.nextToken());
			for(int n = 0; n < numa; n++) {
				a = Integer.parseInt(st.nextToken());
				A[a]++;
			}
			st = new StringTokenizer(in.readLine());
			numb = Integer.parseInt(st.nextToken());
			for(int n = 0; n < numb; n++) {
				b = Integer.parseInt(st.nextToken());
				B[b]++;
			}
			
			res = cmp(A, B);
			if(res == 1)
				sb.append("A\n");
			else if(res == -1)
				sb.append("B\n");
			else
				sb.append("D\n");
		}
		System.out.print(sb.toString());
	}
	
	static int cmp(int[] A, int[] B) {
		for(int i = 4; i > 0; i--) {
			if(A[i] > B[i])
				return 1;
			else if(A[i] < B[i])
				return -1;
		}
		return 0;
	}
}

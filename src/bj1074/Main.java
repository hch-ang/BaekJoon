package bj1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, r, c;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int plane = 1;
		for(int i = 0; i < N; i++) plane *= 2;
		int result = compute(plane, r, c);
		System.out.println(result);
	}
	
	static int compute(int plane, int r, int c) {
		int res = 0;
		int square = (plane/2)*(plane/2);
		if(r >= plane/2) {
			res += square * 2;
			r -= plane/2;
		}
		if(c >= plane/2) {
			res += square;
			c -= plane/2;
		}
		if(plane == 2)
			return res;
		else {
			plane /= 2;
			return res + compute(plane, r, c);
		}
	}
}

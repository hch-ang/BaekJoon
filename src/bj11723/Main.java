package bj11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int M;
	static boolean[] set = new boolean[21];
	public static void main(String[] args) throws NumberFormatException, IOException {
		M = Integer.parseInt(in.readLine());
		String op;
		int num;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			op = st.nextToken();
			if(op.charAt(0) == 'a') {
				if(op.charAt(1) == 'd') {
					num = Integer.parseInt(st.nextToken());
					set[num] = set[num]|true;
				}
				else {
					for(int n = 1; n <= 20; n++)
						set[n] = true;
				}
			}
			else if(op.charAt(0) == 'r') {
				num = Integer.parseInt(st.nextToken());
				set[num] = set[num]&false;
			}
			else if(op.charAt(0) == 'c') {
				num = Integer.parseInt(st.nextToken());
				if(set[num])
					sb.append("1\n");
				else
					sb.append("0\n");
			}
			else if(op.charAt(0) == 't') {
				num = Integer.parseInt(st.nextToken());
				set[num] = !set[num];
			}
			else {
				for(int n = 1; n <= 20; n++)
					set[n] = false;
			}
		}
		System.out.println(sb.toString());
	}
}

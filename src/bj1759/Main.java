package bj1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int L, C;
	static String[] tokens;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		tokens = new String[C];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < C; i++) {
			tokens[i] = st.nextToken();
		}
		Arrays.sort(tokens);
		
		StringBuilder sb;
		for(int i = 0; i <= C - L; i++) {
			sb = new StringBuilder().append(tokens[i]);
			if("aeiou".contains(tokens[i]))
				recur(sb, 1, i, 0, 1);
			else
				recur(sb, 1, i, 1, 0);	
		}	
	}
	
	static void recur(StringBuilder sb, int iterator, int index, int wkdma, int ahdma) {
		if(iterator == L) {
			if(wkdma >= 2 && ahdma >= 1)
				System.out.println(sb.toString());
			return;
		}
		
		StringBuilder tempsb;
		for(int i = index+1; i <= C - L + iterator; i++) {
			tempsb = new StringBuilder().append(sb.toString()).append(tokens[i]);
			if("aeiou".contains(tokens[i]))
				recur(tempsb, iterator + 1, i, wkdma, ahdma + 1);
			else
				recur(tempsb, iterator + 1, i, wkdma + 1, ahdma);	
		}		
	}
}

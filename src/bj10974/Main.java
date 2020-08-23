package bj10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	static BufferedReader in;
	static int N;
	static boolean[] sig;
//	static List<Integer> list = new ArrayList<>();
	static int[] list;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		sig = new boolean[N+1];
		list = new int[N];
		for(int i = 1; i <= N; i++) {
			if(sig[i] == false) {
				sig[i] = true;
//				list.add(i);
				list[0] = i;
				comb(1);
				sig[i] = false;
//				list.remove(0);
			}
		}
	}
	
	static void comb(int iteration) {
		if(iteration == N) {
			myPrint();
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(sig[i] == false) {
				sig[i] = true;
//				list.add(i);
				list[iteration] = i;
				comb(iteration + 1);
				sig[i] = false;
//				list.remove(iteration);
			}
		}
	}
	
	static void myPrint() {
		StringBuilder sb = new StringBuilder();
//		Iterator<Integer> iter = list.iterator();
//		while(iter.hasNext())
//			sb.append(iter.next() + " ");
		for(int i = 0; i < N; i++)
			sb.append(list[i] + " ");
		System.out.println(sb.toString());
	}
}

package bj2628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int W, H, T, Wcut, Hcut;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int[][] arr = new int[H][W];
		
		Wcut = 0;
		Hcut = 0;
		T = Integer.parseInt(in.readLine());
		int[][] cuts = new int[T][2];
		int tipo, line;
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(in.readLine());
			tipo = Integer.parseInt(st.nextToken());
			line = Integer.parseInt(st.nextToken());
			cuts[t][0] = tipo;
			cuts[t][1] = line;
			Wcut += tipo == 1 ? 1 : 0;
			Hcut += tipo == 0 ? 1 : 0;
		}
		
		int[] arrH = new int[Hcut+2];
		arrH[Hcut] = 0;
		arrH[Hcut+1] = H;
		int[] arrW = new int[Wcut+2];
		arrW[Wcut] = 0;
		arrW[Wcut+1] = W;
		
		int hidx = 0;
		int widx = 0;
		for(int t = 0; t < T; t++) {
			if(cuts[t][0] == 0)
				arrH[hidx++] = cuts[t][1];
			else
				arrW[widx++] = cuts[t][1];
		}
		Arrays.sort(arrH);
		Arrays.sort(arrW);
		
//		System.out.println("Hcut : " + Hcut + ", Wcut : " + Wcut);
//		for(int i = 0; i < Hcut+2; i++)
//			System.out.print(arrH[i] + " ");
//		System.out.println();
//		for(int i = 0; i < Wcut+2; i++)
//			System.out.print(arrW[i] + " ");
//		System.out.println();
		
		int maxH = 0;
		for(int i = 0; i < Hcut+1; i++)
			maxH = maxH > arrH[i+1] - arrH[i] ? maxH : arrH[i+1] - arrH[i];
		int maxW = 0;
		for(int i = 0; i < Wcut+1; i++)
			maxW = maxW > arrW[i+1] - arrW[i] ? maxW : arrW[i+1] - arrW[i];
			
		System.out.println(maxH * maxW);
		
	}
}

package bj1476;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int E = sc.nextInt()-1;
		int S = sc.nextInt()-1;
		int M = sc.nextInt()-1;
		
		int tempmul = find(E, 15, S, 28);

		System.out.println(find(tempmul*15 + E, 15*28, M, 19)*28*15 + (tempmul*15) + E + 1);		
	}
	
	static int find(int a, int A, int b, int B) {
		int mula = 0;
		int mulb = 0;
		int numa = a;
		int numb = b;
		while(true) {
			if(numa == numb)
				return mula;
			if(numa > numb) {
				numb += B;
				mulb++;
			}
			else {
				numa += A;
				mula++;
			}
		}
	}
}

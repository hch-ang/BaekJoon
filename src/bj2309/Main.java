package bj2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Integer arr[];
	static int sig[] = new int[9];
	static int ssum = -100;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new Integer[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			ssum += arr[i];
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < 8; i++) {
			for(int j = i+1; j < 9; j++) {
				if(arr[i] + arr[j] == ssum) {
					sig[i] = 1;
					sig[j] = 1;
					for(int k = 0; k < 9; k++) {
						if(sig[k] == 0)
							System.out.println(arr[k]);
					}
					return;
				}
			}
		}
	}	
}

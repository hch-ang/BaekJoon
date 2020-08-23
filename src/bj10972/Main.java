package bj10972;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[] arr;
	static PriorityQueue <Integer> Q;
	static PriorityQueue <Integer> Q2;
	
	public static void main(String[] args) {
		N = sc.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Q = new PriorityQueue<Integer>();
		Q2 = new PriorityQueue<Integer>();
		int index = N-1;
		int number = arr[N-1];
		while(arr[index] >= number) {
			number = arr[index];
			index--;
			if(index < 0)
				break;
		}
		if(index == -1) {
			System.out.println(-1);
			return;
		}
		number = arr[index];
		for(int i = 0; i < index; i++)
			System.out.print(arr[i] + " ");
		for(int i = index; i < N; i++) {
			if(arr[i] <= number)
				Q.add(arr[i]);
			else
				Q2.add(arr[i]);
		}
		System.out.print(Q2.poll() + " ");
		while(Q.size() > 0)
			System.out.print(Q.poll() + " ");
		while(Q2.size() > 0)
			System.out.print(Q2.poll() + " ");			
	}
}

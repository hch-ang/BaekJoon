package bj14226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int S;
	static boolean[][] sig = new boolean[2000][1000];
	static Queue<Node> Q = new LinkedList<Node>();
	public static void main(String[] args) {
		S = sc.nextInt();
		Q.add(new Node(1, 0, 0));
		sig[0][0] = true;
		Node temp;
		int num, copy, count;
		while(!Q.isEmpty()) {
			temp = Q.poll();
			num = temp.num;
			copy = temp.copy;
			count = temp.count;
			if(num == S) {
				System.out.println(count);
				return;
			}
			if(num > 0) {
				if(sig[num-1][copy] == false) {
				sig[num-1][copy] = true;
				Q.add(new Node(num-1, copy, count+1));
				}
				if(num < 1000 && sig[num][num] == false) {
					sig[num][num] = true;
					Q.add(new Node(num, num, count+1));
				}
			}
			if(num < 1000 && sig[num + copy][copy] == false) {
				sig[num + copy][copy] = true;
				Q.add(new Node(num + copy, copy, count+1));
			}
		}
	}
}

class Node {
	int num;
	int copy;
	int count;
	Node(int num, int copy, int count) {
		this.num = num;
		this.copy = copy;
		this.count = count;
	}
}
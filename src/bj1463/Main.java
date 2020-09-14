package bj1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader (System.in)).readLine());
		Queue <Node> Q = new LinkedList<Node>();
		Q.add(new Node(N, 0));
		boolean[] sig = new boolean[N+1];
		sig[N] = true;
		Node temp;
		
		int num, count, next;
		while(!Q.isEmpty()) {
			temp = Q.poll();
			num = temp.num;
			count = temp.count;
			if(num == 1) {
				System.out.println(count);
				return;
			}
			
			if(num % 3 == 0) {
				next = num / 3;
				if(!sig[next]) {
					sig[next] = true;
					Q.add(new Node(next, count + 1));
				}	
			}
			
			if(num % 2 == 0) {
				next = num / 2;
				if(!sig[next]) {
					sig[next] = true;
					Q.add(new Node(next, count + 1));
				}	
			}
			
			next = num - 1;
			if(!sig[next]) {
				sig[next] = true;
				Q.add(new Node(next, count + 1));
			}	

		}
	}
	
}


class Node {
	int num;
	int count;
	Node() {}
	Node(int num, int count) {
		this.num = num;
		this.count = count;
	}
}

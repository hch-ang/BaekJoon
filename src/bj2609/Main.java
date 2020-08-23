package bj2609;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        if(B > A) {
            int temp = A;
            A = B;
            B = temp;
        }
        int gcd = GCD(A, B);
        System.out.println(gcd);
        System.out.println(A*B/gcd);
    }
    
    static int GCD(int A, int B) {
        if(A%B == 0)
            return B;
        else
            return GCD(B, A%B);
	}

}

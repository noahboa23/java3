// Noah Acosta - 

import java.util.*;
public class hw1 {
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter an integer >= to 4: ");
        int num = in.nextInt();

        int A, B, C, D;
        do {
        A = (int)(Math.random()*num)+1;
        B = (int)(Math.random()*num)+1;
        C = (int)(Math.random()*num)+1;
        D = (int)(Math.random()*num)+1;
        } while (A+B+C+D != num);

        System.out.println("These numbers sum up to " + num + ": " + A + ", " + B+", "+C+", "+D);
    }
} //end program 1


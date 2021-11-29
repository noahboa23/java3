// Noah Acosta; HW 1 Program 1: COSC 2436

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

// Noah Acosta; HW 1 Program 2: COSC 2436

public class hw1 {
    public static void main (String [] args)
    {

        System.out.println("3,1,5 = " + SameDifferent(3,1,5));
		System.out.println("2,0,2 = " + SameDifferent(2,0,2));
		System.out.println("5,5,5 = " + SameDifferent(5,5,5));
		System.out.println("8,9,2,4 = " + SameDifferent(8,9,2,4));
		System.out.println("7,7,1,7 = " + SameDifferent(7,7,1,7));
		System.out.println("4,4,4,4 = " + SameDifferent(4,4,4,4));
    }

    static String SameDifferent (int A, int B, int C)
    {
        String same = "Same";
        String similar = "Similar";
        String diff = "Different";

        if (A == B && B == C)
            return same;
        else if (A != B  && B != C && C == A)
            return similar;
        else if (A != B && B != C && C != A)
            return diff;
        else return null;
    }
    static String SameDifferent (int A, int B, int C, int D)
    {
        String same = "Same";
        String similar = "Similar";
        String diff = "Different";
        if (A == B && B == C && C == D)
            return same;
        else if (A == B && B != C &&  C != D && D == A)
            return similar;
        else if (A != B && B != C && C != D)
            return diff;
        else return null;
    }

} // end program 2

// Noah Acosta; HW 1 Program 3: COSC 2436

public class hw1 {
    public static void main (String [] args)
    {
        Student S1 = new Student("Gonzalez", "Juan", 19, 3.8);
		Student S2 = new Student("Brown", "Leanne", 20, 3.4);
		Student S3 = new Student("Kumar", "Raj", 20, 3.5);
		Student S4 = new Student("Tucker", "Alexa", 21, 3.9);

        // calculate and output average Age and average GPA

        int add = S1.getAge() + S2.getAge() + S3.getAge() + S4.getAge();
        int avg = add / 4;

        double add2 = S1.getGpa() + S2.getGpa() + S3.getGpa() + S4.getGpa();
        double avgGpa = add2 / 4;

        System.out.println("The average age is: " + avg);
        System.out.println("The average gpa is: " + avgGpa);
    }
}

class Student {
    String lastName, firstName;
    int age;
    double gpa;

    Student(String last, String first, int year, double grade)
    {
        lastName = last; firstName = first; age = year; gpa = grade;
    }
    int getAge()
    {
        return age;
    }
    double getGpa()
    {
        return gpa;
    }
} // end program 3


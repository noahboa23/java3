// Noah Acosta- 4 programs implementing recursion 
import java.util.*;

public class recurse {
	static String CLS = "\033[2J\033[1;1H";
	static long methodCount = 0;
	static long method = 0;

	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.println("\n**** PROGRAM 1 ****");
		System.out.print("How many bunnies are in the line? ");
		int n = in.nextInt();
		int ears = BunnyEars(n); 
		System.out.println("This is a total of " + ears + " ears."); //end prog1


		System.out.println("\n**** PROGRAM 2 ****");
		System.out.print("Please enter an integer: ");
		int num = in.nextInt();
		int sum = SumDigits(num);
		System.out.println("The sum of these digits is: " + sum); //end prog2
		System.out.println();
		in.nextLine();
		
		
		System.out.println("\n**** PROGRAM 3 ****");
		System.out.print("Please enter a string: ");
		String s = in.nextLine();
		String rev = RevString(s);
		System.out.println("Your string in reverse: " + rev);//end prog3
		System.out.println();

		
		System.out.println("\n**** PROGRAM 4 ****");
		System.out.print("Which Fibonacci number would you like to calculate? ");
		long number = in.nextLong();
		long startTime = System.currentTimeMillis();
		// methodCount = Math.pow(2,number);
		// int method1 = (int)methodCount;
		long x=fib(number);
		long endTime = System.currentTimeMillis();
		System.out.println("\nThis Fibonacci number = " + x);
		System.out.println("Number of method calls made = " + methodCount);
		System.out.println("Seconds used for this calculation: " + (endTime - startTime)/1000.0);//end prog 4


		System.out.println("\n**** EXTRA CREDIT PROGRAM ****");
		System.out.print("Which Fibonacci number would you like to calculate? ");
		long numero = in.nextLong();
		long startTime2 = System.currentTimeMillis();
		// method = Math.pow(2,numero);
		// int methodC = (int)method;
		long y=fib2(numero);
		long endTime2 = System.currentTimeMillis();
		System.out.println("\nThis Fibonacci number = " + y);
		System.out.println("Number of method calls made = " + method);
		System.out.println("Seconds used for this calculation: " + (endTime2 - startTime2)/1000.0); //end extra
		System.out.println();
	} //END MAIN 

//methods 
	static int BunnyEars(int k) {
		if (k == 0)
			return 0;
		if (k % 5 == 0)
			return 1 + BunnyEars(k-1);
		else if (k % 2 == 0)
			return 2 + BunnyEars (k-1);
		else if (k % 2 != 0)
			return 3 + BunnyEars(k-1);
		else 
			return 0;
	}

	static int SumDigits (int k) {
		if (k == 0)
			return 0;
		return (k % 10 + SumDigits(k / 10)); 
	}

	static String RevString(String s) {
		if (s.isEmpty())
			return " ";
		return s.substring(s.length()-1, s.length()) + RevString(s.substring(0,s.length()-1));
	}

	static long fib(long n) {
		methodCount++;
		if (n <= 1)
			return n;
		return fib(n-1) + fib(n-2);
	}

	static long fib2(long n) {
		long a = 0, b=1, c;
		
		if(n==0)
			return a;

		for(int i = 2; i<= n; ++i){
			c = a+b;
			a=b;
			b=c;
			method++;
		}
		return b;
	}
} //end 

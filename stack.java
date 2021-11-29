// Noah Acosta - these programs implement the use of stacks
import java.util.*;

public class hw4 {
	static String Green = "\033[32;1m";
	static String Normal = "\033[0m";
	static String Red = "\033[31;1m";
	static String Purple = "\033[35;1m";
	static String Cyan = "\033[36;1m";
	static String Yellow = "\033[33;1m";

	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.println("\n=============================================================================");

		System.out.println("\n***** Program 1 *****"+Normal);
		// ask user to enter a string of () [] {} 
		System.out.println(Purple+"\nThis program checks if the parenthesis, brackets, and braces are balanced.\n" + Normal);
		System.out.print("Please enter a string: ");
		String input = in.nextLine();
		balanced(input);
		if (balanced(input) == true)
			System.out.println(Green+"You have entered a balanced string!\n"+Normal);
		else if (balanced(input) == false)
			System.out.println(Red+"Sorry! This string is NOT balanced.\n"+Normal);
		System.out.println("=============================================================================");

		System.out.println("\n***** Program 2 *****");
		Stack<Character> s = new Stack<Character>();
		// ask user to enter equation
		String get;
		System.out.println(Cyan+"\nNOTE: This program can calculate an equation as long as what is entered\n is calculable and single digit. ie: (2/3) will not work!"+Normal);
		System.out.print("\nPlease enter an equation: ");
		get = in.nextLine();
		System.out.println(Yellow+"The solution is: " + eval(get)+Normal);
		System.out.println("\n=============================================================================\n");

	} // end main
// METHODS
	static boolean balanced(String s) 
	{
		Stack<Character> alpha = new Stack<Character>();
		for(int i=0;i<s.length();i++)
		{
			if (s.charAt(i) == '(')
				alpha.push('(');
			if (s.charAt(i) == '[')
				alpha.push('[');
			if(s.charAt(i) == '{')
				alpha.push('{');
			else if(s.charAt(i) == ')' && alpha.isEmpty() || s.charAt(i) == ']' && alpha.isEmpty() || s.charAt(i) == '}' && alpha.isEmpty())
				return false;
			else if(s.charAt(i) == ')') 
			{
				if(alpha.pop() != '(' )
					return false;
			}
			else if(s.charAt(i) == ']')
			{
				if(alpha.pop() != '[')
					return false;
			}
			else if(s.charAt(i) == '}')
			{
				if(alpha.pop() != '{')
					return false;
			}
		} 
		if (alpha.isEmpty())
			return true;
		else
			return false;
	} // end balanced
	static int eval(String e)
	{
		Stack<Integer> value = new Stack<Integer>();
		Stack<Character> operator = new Stack<Character>();
		int a=0;
		int b=0;
		for(int i=0;i<e.length(); i++) // step thru e/a char
		{
			if(e.charAt(i) >= '0' && e.charAt(i) <= '9')
				value.push( Character.getNumericValue( e.charAt(i) ));
			else if(e.charAt(i) == '+' || e.charAt(i) == '-' || e.charAt(i) == '*' || e.charAt(i) == '/' || e.charAt(i) == '(' )
				operator.push(e.charAt(i));
			else if(e.charAt(i) == ')')
			{
				char op=operator.pop();
				a=value.pop();
				b=value.pop();
				if(op == '+')
					value.push(a+b);
				else if(op == '-')
					value.push(b-a);
				else if(op == '*')
					value.push(a*b);
				else if(op == '/')
					value.push(b/a);
				operator.pop();
			}
		}
		while (!operator.isEmpty()) // loop while not empty 
		{
			char op=operator.pop();
			a=value.pop();
			b=value.pop();
			if(op == '+')
				value.push(a+b);
			else if(op == '-')
				value.push(b-a);
			else if(op == '*')
				value.push(a*b);
			else if(op == '/')
				value.push(b/a);
		}
		return value.pop();
	}// end eval
}// END 
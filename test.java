import java.util.*;
public class test {
    public static void main (String [] args)
    {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String nombre = in.nextLine();
		System.out.println("Your name is: " + nombre);
		in.close();
    }
} // END
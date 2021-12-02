/* Noah Acosta - this program implements Hashing */
import java.util.*;
import java.io.*;
public class flora {
	static String Red = "\033[31;1m";
	static String Green = "\033[32;1m";
	static String Purple = "\033[35;1m";
	static String Cyan = "\033[36;1m";
	static String Yellow = "\033[33;1m";
	static String Normal = "\033[0m";
	
	public static void main (String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		Scanner infile = new Scanner(new File("flora.csv"));

		Hashtable<String, String> flora = new Hashtable<String, String>();
		String temp;

		while(infile.hasNextLine())
		{
			temp = infile.nextLine(); // read line from flora.csv
			String[] parts = temp.split(","); // splits the csv into two
			flora.put(parts[0], parts[1]); // puts it into the hashtable

		}
		int choice = 0;
		while(choice != 4)
		{
			System.out.println(Purple+"=================================================="+Normal);
			System.out.println(flora.size() + " flora read into hashtable...");
			System.out.println();
			System.out.println("\t\t**** MAIN MENU ****");
			System.out.println("1 = Search for a flora");
			System.out.println("2 = Add a new flora");
			System.out.println("3 = Delete a flora");
			System.out.println("4 = Exit");
			System.out.println(Purple+"\n=================================================="+Normal);
			System.out.print("Enter your choice: ");
			choice = in.nextInt();

			if(choice == 1)
			{
				System.out.println(Cyan+"--------------------------------------------------"+Normal);
				System.out.print("Enter flora name: ");
				in.nextLine(); // used to get user input as program can loop infinite 
				String input = in.nextLine();
				flora.containsKey(input);
				if(flora.containsKey(input) == true)
					System.out.println(Green+"This Flora was found! "+Yellow+" Family: " +Normal+ flora.get(input));
				else
					System.out.println(Red+"Sorry! " +input+ " was not found!"+Normal);
				System.out.println();
			}
			if(choice == 2)
			{
				System.out.println(Cyan+"--------------------------------------------------"+Normal);
				System.out.print("Enter flora name: ");
				in.nextLine();
				String newFlora = in.nextLine();
				System.out.print("Enter family name: ");
				String newFam = in.nextLine();
				flora.put(newFlora,newFam);
				System.out.println(Green+"New Flora has been added!"+Normal);
				System.out.println();
			}
			if(choice == 3)
			{
				System.out.println(Cyan+"--------------------------------------------------"+Normal);
				System.out.print("Enter flora name: ");
				in.nextLine();
				String input2 = in.nextLine();
				if(flora.containsKey(input2) == false)
					System.out.println(Red+"Sorry! " +input2+ " was not found!"+Normal);
				if(flora.containsKey(input2) == true){
					flora.remove(input2);
					System.out.println(Green+input2 + " has been removed!"+Normal);
				}
				System.out.println();
			}
		} // end menu
	} // end main
} // END
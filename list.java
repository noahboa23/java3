// Noah Acosta - this program implements linked lists
import java.util.*;
import java.io.*;

public class list {
    static String Red = "\033[31;1m";
    static String Green = "\033[32;1m";
    static String Purple = "\033[35;1m";
    static String Cyan = "\033[36;1m";
    static String Normal = "\033[0m";
	public static void main (String[] args) throws IOException
	{
		Scanner infile = new Scanner(new File("primes4.txt"));
		Scanner in = new Scanner (System.in);

		System.out.println("\nReading file of 1 MILLION prime numbers...");
		
		Node head = new Node(infile.nextInt());
		Node temp = null;
		while (infile.hasNextInt()) 
		{
			temp = new Node(infile.nextInt());
			temp.next = head;
			head = temp;
		}
		int choice = 0;
		System.out.println("File Ready!\n");
		while(choice != 4)
		{
			System.out.println(Purple+"=================================================="+Normal);
			System.out.println("\t\tMAIN MENU");
			System.out.println("Please make a selection...");
			System.out.println("1. Search for a number.");
			System.out.println("2. Add a number.");
			System.out.println("3. Delete a number.");
			System.out.println("4. Exit.");
			System.out.println(Purple+"\n=================================================="+Normal);
			System.out.print("Enter Your Choice: ");
			choice = in.nextInt();

			if(choice == 1)
			{
				// search
				System.out.println(Cyan+"--------------------------------------------------"+Normal);

				System.out.print("Please enter a number: ");
				int search = in.nextInt();
		
				/* step thru linked list and search for an item */
				boolean found = false;
				temp=head; // they will point to the same address
				while (temp != null)
				{
					if(temp.data==search)
						found = true;
					temp=temp.next;
				}
				if(found)
					System.out.println(Green+ search + " was found!"+Normal);
				else
					System.out.println(Red+"Nothing was found :("+Normal);
				System.out.println();
			}
			if(choice == 2)
			{
				/* add a new node to linked list */
				System.out.println(Cyan+"--------------------------------------------------"+Normal);

				System.out.print("Please enter a number to add: ");
				int search = in.nextInt();
				temp = new Node(search);
				temp.next=head; // make next point to what head is
				head = temp; // makes temp the new head
				System.out.println(Green+search + " has been added!"+Normal);
				System.out.println();
			}
			if(choice == 3)
			{
				/* Search for a num and delete node */
				System.out.println(Cyan+"--------------------------------------------------"+Normal);

				System.out.print("Please enter a number to delete: ");
				int search = in.nextInt();
				boolean found = false;
				Node previous = null;
				temp=head; // they will point to the same address
				while (temp != null)
				{
					if(temp.data==search)
					{
						found = true;
						previous.next=temp.next; // temp.next will point to 42 so previous.next will also point to 42
					}
					previous = temp;
					temp=temp.next;
				}
				if(found)
					System.out.println(Green+ search + " was deleted!"+Normal);
				else
					System.out.println(Red+search + " was NOT found :("+Normal);
				System.out.println();
			}
		}
	}
} // END

class Node
{
	int data;
	Node next; // allows to make 1 of obj nodes point to another node obj
	
	Node(int newData) // constructor
	{
		 data = newData;
	}
}
	
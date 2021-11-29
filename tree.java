// Noah Acosta - this program implements binary trees
import java.util.*;
import java.io.*;
public class tree {
	static String Red = "\033[31;1m";
	static String Green = "\033[32;1m";
	static String Purple = "\033[35;1m";
	static String Cyan = "\033[36;1m";
	static String Normal = "\033[0m";
	static String Yellow = "\033[33;1m";
	static int currentDepth = 0;
	public static void main (String[] args) throws IOException
	{
		Scanner in = new Scanner (System.in);
		Scanner infile = new Scanner(new File("primes4.txt"));

		Node root = new Node(infile.nextInt()); // create root node
		System.out.println();
		System.out.println("Building a binary tree using 1,000,000 prime numbers... ");
		System.out.println(Cyan+"--------------------------------------------------"+Normal);
		int maxDepth=0; 
		int sumofDepths = 0;

		while (infile.hasNextInt())
		{
			currentDepth = 0;
			insert(root, infile.nextInt()); // builds the tree
			sumofDepths += currentDepth;
			if(currentDepth > maxDepth)
				maxDepth = currentDepth;
		}
		System.out.println("Maximum Depth of the Binary Tree = " + maxDepth);
		System.out.println(Cyan+"--------------------------------------------------"+Normal);
		System.out.println("Average Depth of the Binary Tree = " + (sumofDepths) / 1000000);
		System.out.println(Cyan+"--------------------------------------------------"+Normal);

		System.out.print("Please enter a number to search in the tree: ");
		int num = in.nextInt(); // ask user to enter a number to search
		if(locate(root,num))
			System.out.println(Green+num + " is a prime number in the tree!\n"+Cyan+"--------------------------------------------------"+Normal);
		else 
		{
			System.out.println(Red+num + " is NOT a prime number and NOT in the tree!"+Normal);
			System.out.println(Cyan+"--------------------------------------------------"+Normal);

			// locate nearest prime less than num
			int lessThan = num;
			while (!locate(root,lessThan)) {
				lessThan--;
			}
			System.out.println("Nearest prime less than your number is: "+Yellow+lessThan+Normal);

			// locate nearest prime greater than num
			int greaterThan = num;
			while(!locate(root,greaterThan)) {
				greaterThan++;
			}
			System.out.println("Nearest prime greater than your number is: "+Purple+greaterThan+Normal);
			System.out.println(Cyan+"--------------------------------------------------"+Normal);
		}
		
	}// end main

	static boolean locate(Node theNode, int theData)
	{
		if(theNode == null)
			return false;
		if(theNode.data == theData)
			return true;
		else if(theNode.data > theData) // traverse tree to the left
			return locate(theNode.left, theData);
		else if(theNode.data < theData)
			return locate(theNode.right, theData); // traverse tree to the right
		else if(theNode.data > theData && theNode.left == null)
			return false;
		else if(theNode.data < theData && theNode.right == null)
			return false;
		else
			return false; // default return
	} // end locate method

	static void insert(Node theNode, int newData) /* NOTE: every time it recurses, the depth increases by 1 */
	{
		currentDepth++;
		if(theNode.data > newData && theNode.left == null) /* left is null - add new node on left */
		{
			Node t = new Node(newData);
			theNode.left = t;
		}
		else if(theNode.data < newData && theNode.right == null) /* right is null - add new node on right */
		{
			Node t = new Node(newData);
			theNode.right = t;
		}
		else if(theNode.data > newData && theNode.left != null){ // left isnot null, recurse to left
			insert(theNode.left, newData);
		}
		else if(theNode.data < newData && theNode.right != null){ // right is not null, recurse to right
			insert(theNode.right , newData);
		}
	} // end insert method
} // end test2 class

class Node
{
	int data;
	Node left, right;

	Node(int theData)
	{
		data=theData;
	}
} // end Node
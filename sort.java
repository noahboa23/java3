// Noah Acosta - compare different sorting alogrithms 
import java.util.*;
import java.io.*;

public class sort {
    static long bubIt = 0;
    static long selIt = 0;
    static long mergeIt = 0;
    static long radixIt = 0;
    static String Red = "\033[31;1m";
    static String Green = "\033[32;1m";
    static String Purple = "\033[35;1m";
    static String Cyan = "\033[36;1m";
    static String Normal = "\033[0m";
    public static void main (String[] args) throws IOException
    {
        Scanner infile = new Scanner(new File("primes1.txt"));
        int n = 100000; 
        int[] data1 = new int[n]; // use for bubble
        int[] data2 = new int[n]; // use for selection
        ArrayList<Integer> data3 = new ArrayList<Integer>(); // used for merge
        ArrayList<Integer> data4 = new ArrayList<Integer>(); // used for radix

        /* read numbers into array */
        int a; //used to read in data
        System.out.println("\nReading array of "+n+" numbers...");
        for (int i=0; i<n; i++)
        {
            a = infile.nextInt();
            data1[i] = a;
            data2[i] = a;
            data3.add(a);
            data4.add(a);
        }

        // call bubble sort
        System.out.println(Red+"\nBeginning bubble sort of "+n+" numbers...\n~This might take a while so sit tight!");
        long beginTime = System.currentTimeMillis();
        data1 = bubbleSort(data1);
        long endTime = System.currentTimeMillis();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("**** Bubble Sort ****\n");
        System.out.println("Elapsed seconds: " + (endTime - beginTime)/1000.0);
        System.out.println("Number of iterations: "+bubIt);
        // print first 10 numbers of bubble sort
        System.out.println("The first 10 sorted numbers are: ");
        for(int i=0;i<10;i++)
            System.out.print(data1[i] +" ");
        System.out.println();
        // print last 10 numbers of bubblesort
        System.out.print("The last 10 sorted numbers are:\n");
        for (int y = n-10; y < n; y++) 
            System.out.print(data1[y] + " ");
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.println("\n"+Normal);

        // call Selection Sort
        System.out.println(Green+"Beginning selection sort of " +n+" numbers...\n~This one is faster, somewhat...");
        long beginTime2 = System.currentTimeMillis();
        data2 = selectionSort(data2);
        long endTime2 = System.currentTimeMillis();
        System.out.println("-----------------------------------------------------");
        System.out.println("\n**** Selection Sort ****\n");
        System.out.println("Elapsed seconds: " + (endTime2 - beginTime2)/1000.0);
        System.out.println("Number of iterations: " + selIt);
        // print first 10 numbers of selection sort
        System.out.println("The first 10 sorted numbers are: ");
        for(int i=0;i<10;i++)
            System.out.print(data2[i] +" ");
        System.out.println();
        // print last 10 numbers of selection sort
        System.out.print("The last 10 sorted numbers are:\n");
        for (int y = n-10; y < n; y++) 
            System.out.print(data2[y] + " ");
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.println("\n"+Normal);

        // call merge sort
        System.out.println(Purple+"Beginning merge sort of " +n+" numbers...\n~This is very fast!");
        long beginTime3 = System.currentTimeMillis();
        data3 = mergeSort(data3);
        long endTime3 = System.currentTimeMillis();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("\n**** Merge Sort ****\n");
        System.out.println("Elapsed seconds: "+(endTime3 - beginTime3)/1000.0);
        System.out.println("Number of iterations: "+ mergeIt);
        // print first 10 numbers of merge sort
        System.out.println("The first 10 sorted numbers are: ");
        for(int i=0;i<10;i++)
            System.out.print(data3.get(i) +" ");
        System.out.println();
        // print last 10 numbers of merge sort
        System.out.print("The last 10 sorted numbers are:\n");
        for (int y = n-10; y < n; y++) 
            System.out.print(data3.get(y) + " ");
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.println("\n"+Normal);

        // call radix sort
        System.out.println(Cyan+"Beginning radix sort of " +n+" numbers...\n~Lightning Fast!");
        long beginTime4 = System.currentTimeMillis();
        data4 = radixSort(data4);
        long endTime4 = System.currentTimeMillis();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("\n**** Radix Sort ****\n");
        System.out.println("Elapsed seconds: "+(endTime4 - beginTime4)/1000.0);
        System.out.println("Number of iterations: "+ radixIt);
        // print first 10 numbers of radix sort
        System.out.println("The first 10 sorted numbers are: ");
        for(int i=0;i<10;i++)
            System.out.print(data4.get(i) +" ");
        System.out.println();
        // print last 10 numbers of radix sort
        System.out.print("The last 10 sorted numbers are:\n");
        for (int y = n-10; y < n; y++) 
            System.out.print(data4.get(y) + " ");
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.println("\n"+Normal);
    } // end main
    
//methods 
    //bubble sort
    static int[] bubbleSort(int[] data) 
    {
        int temp;
        for (int x=0; x<data.length; x++)
        {
            for (int y=0; y<data.length-1-x; y++)
            {
                bubIt++;
                if (data[y] > data[y+1]) 
                {
                    temp = data[y];
                    data[y] = data[y+1];
                    data[y+1] = temp;
                }
            }
        }
        return data;
    } // end bubbleSort

    static int[] selectionSort(int[] data)
    {
        int temp;
        for (int x=0;x<data.length;x++)
        {
            int min = x; // data[x] will start as the smallest value
            for (int y=x;y<data.length; y++)
            {
                selIt++;
                if(data[y] < data[min])
                {
                    min = y;
                }
            }
            // swap data[x] with data[min]
            temp = data[x];
            data[x] = data[min];
            data[min] = temp;
        }
        return data;
    } // end selectionSort

    static ArrayList<Integer> mergeSort(ArrayList<Integer> dataset) 
    {
        mergeIt++;
        if (dataset.size() == 1) 
            return dataset;
        else 
        {
            // split data into 2 parts
            ArrayList<Integer> LeftData = new ArrayList<Integer>(dataset.subList(0,dataset.size()/2));
            ArrayList<Integer> RightData = new ArrayList<Integer>(dataset.subList(dataset.size()/2,dataset.size()));
            dataset = Merge(mergeSort(LeftData), mergeSort(RightData)); // recursion
        }
        return dataset;
    }// end mergeSort
    // merge the left and right lists together
    static ArrayList<Integer> Merge(ArrayList<Integer> LeftData, ArrayList<Integer> RightData) 
    {
        ArrayList<Integer> MergedData = new ArrayList<Integer>();
        while (LeftData.size() > 0 || RightData.size() > 0) 
        {
            mergeIt++;
            if (RightData.size() == 0)
            {
                MergedData.add(LeftData.get(0));
                LeftData.remove(0);
            }
            else if (LeftData.size() == 0)
            {
                MergedData.add(RightData.get(0));
                RightData.remove(0);
            }
            else if (LeftData.get(0) < RightData.get(0))
            {
                MergedData.add(LeftData.get(0));
                LeftData.remove(0);
            }
            else
            {
                MergedData.add(RightData.get(0));
                RightData.remove(0);
            }
        }
        return MergedData;
    } // end Merge

    static ArrayList<Integer> radixSort(ArrayList<Integer> dataset)
    {
        ArrayList<Integer> dataset2 = new ArrayList<Integer>();
        for (int k=1; k<= 1000000; k*=10)
        {
            for(int i=0; i<=9; i++)
            {
                for(int j=0; j<dataset.size(); j++)
                {
                    radixIt++;
                    if(dataset.get(j)/k%10 == i)
                        dataset2.add(dataset.get(j));
                }
            }
            dataset.clear();
            for(int m=0; m<dataset2.size(); m++)
            {
                radixIt++;
                dataset.add(dataset2.get(m));
            }
            dataset2.clear();
        }
        return dataset;
    } // end radixSort
} // END
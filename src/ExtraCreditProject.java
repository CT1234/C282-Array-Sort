import java.io.*;
import java.util.*;
public class ExtraCreditProject 
{
	int n;
	
	public static void sortArray(String[] list)
	{
		boolean all_sorted = false;
		String temp;
		while (!all_sorted)
		{
			all_sorted = true;
			for (int i = 0; i < list.length-1; i++)
			{
				if(list[i].compareTo(list[i+1]) > 0)
				{
					temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
					all_sorted = false;
				}
			}
		}
	}	
	
	public static void printWordCount(String[] z) 
	{ 
		sortArray(z);
		String current_string = z[0];
		int word_count = 0;
		for(int i = 0; i < z.length; i++)
		{
			if(z[i].compareTo(current_string) == 0)
				word_count++;
			else
			{
				System.out.println(current_string + "/" + word_count);
				word_count = 1;
				current_string = z[i];
			}
		}
		System.out.println(current_string + "/" + word_count);
	}

	public static void printArray(String[] z) 
	{
		System.out.println("PRINTING ARRAY:");
		for (int j = 1; j <= 15; j++)
			System.out.printf("%10d",j);
			System.out.println();
		for (int i = 0; i < z.length; i++)
		{
			System.out.printf( "%10s",z[i]);
			if ( (i+1) % 15 == 0)
				System.out.println();
		}
		System.out.println("\n");
	}	
	
	public static void main(String[] args) throws FileNotFoundException 
	{ 
		Scanner fileInput = new Scanner(new File("mywords.txt"));
		int n = fileInput.nextInt();
		String[] list = new String[n];
		for ( int i = 0; i < n; i++) 
			list[i] = fileInput.next();
		printArray(list); 
		sortArray(list);
		printArray(list); 
		printWordCount(list);
		fileInput.close();
	}
}


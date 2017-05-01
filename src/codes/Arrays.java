package codes;
import java.util.Scanner;

public class Arrays
{
	
	public static final int SIZE = 100;
	public static int[] manta = new int [SIZE];
	
	public static int errorTrap (int min, int max)
	{
		Scanner input = new Scanner(System.in); // Create scanner
		
		boolean inputSucess; // Boolean for error trap
		int number = 0;
	
		do
		{
			inputSucess = true; //Reset the boolean to prepare for correct input
		
			//Scanner input = new Scanner(System.in);
				
			try
			{
				number = input.nextInt();
			}
				
			catch (Exception e) //If an error occurs in the try statement, catch all exceptions
			{
				input.nextLine(); //Clear the stream of the user entered data
				inputSucess = false; //Set 'inputSucess' to false so the program will loop back to the prompt
			}
				
			if (number < min || number > max || inputSucess == false) //Test if the data is in the correct range
			{
				System.out.println("Invalid data, try agin."); //Informs user that they entered the wrong data
			}
				
		}while (number < min || number > max || inputSucess == false); //Loop back to the prompt if data is incorrect
		
		return number;
	}
	
	public static int randomNumberGenerator (int min, int max)
	{
		int number = (int) (Math.random() * (max - min + 1) + min); //Create random number
		return number;
	}
	
	public static void populateRandomly()
	{
		for (int a = 0; a < SIZE; a++)
		{
			manta[a] = randomNumberGenerator(0,SIZE);
		}
	}
	
	public static void populateSequentially()
	{
		for (int a = 0; a < SIZE; a++)
		{
			manta[a] = a + 1;
		}
	}
	
	public static void displayArray()
	{
		for (int a = 0; a < SIZE; a++)
		{
			System.out.print(manta[a] + " ");
			
			if((a + 1) % 10 == 0) //Every 10 indexes, drop down a line
				System.out.println();
		}
	}
	
	public static void shuffleArray()
	{
		for (int a = 0; a < SIZE; a++)
		{
			int random = randomNumberGenerator(0,(SIZE - 1));
			int temp = manta[a];
			manta [a] = manta[random];
			manta[random] = temp;
		}
	}
	
	public static int findNumber(int number)
	{
		for (int index = 0; index < SIZE; index++)
		{
			if(manta[index] == number)
				return index;
		}
		
		return -1;
	}
	
	public static boolean ascending ()
	{
		
		for (int a = 0; a < (SIZE-1); a++)
		{
			if (manta[a] > manta[a+1]) //if the index before the second index has a greater value, then the array is not in order
				return false;
		}
		
		return true;
	}
	
	public static boolean sortAscending ()
	{
		int counter = 0;
		
		while (counter < 100000 && ascending() == false) //Repeats the process until the array is in order or it reaches 100000
		{
			shuffleArray(); //Shuffles the array until it's in order 
			counter++;
		}
		
		if (counter > 99999) //If the limt was reached, the array is not in order
			return false;
		
		else
			return true;
	}
	
	
	public static int lowestNumber()
	{
		int lowestNumber = manta[0];//start the lowest number at [0] to have somthing to compare to
		
		for (int a = 0; a < SIZE; a++) 
		{
			if (manta[a] < lowestNumber)
				lowestNumber = manta[a]; //if [a] is smaller than the previous lowest numer, then change it to the lowest number
		}
		
		return lowestNumber;
	}
	
	public static int highestNumber()
	{
		int highesNumber = manta[0];//start the higher number at [0] to have somthing to compare to
		
		for (int a = 0; a < SIZE; a++)
		{
			if (manta[a] > highesNumber)
				highesNumber = manta[a]; //if [a] is larger than the previous highest numer, then change it to the highest number
		}
		
		return highesNumber;
	}
	
	public static int occurances(int number)
	{
		int occurances = 0;
		
		for (int a = 0; a < SIZE; a++)
		{
			if (manta[a] == number)
				occurances++;
		}
		
		return occurances;
	}
	
	public static void swap(int number1, int number2)
	{
		for (int a = 0; a < SIZE; a++)
		{
			if (manta[a] == number1)//When the first number is found, it's replaced with the second number
				manta[a] = number2;
		}
	
	}
	
	public static int greatestSumIndexes()
	{
		int start = 0;
		int sum1 = 0;
		int sum2 = 0;
		
		for(int b = 0; b < 10; b++)
		{
			sum1 += manta[b]; //Sets sum1 as the sum of the first 10 numbers to have somthing to compare to 
		}
		
		for (int a = 0; a < (SIZE - 9); a++)//a is the starting index of the indexes of the greatest sum
		{
			
			//System.out.println("Sum1 :" + sum1);
			
			sum2 = 0;
			
			for(int b = a; b < (10 + a); b++) //b is the indexes inside the indexes with the greatest sum
			{
				sum2 += manta[b];//sum2 is what is going to be compared to sum1
			}
			
			//System.out.println("Sum2 :" + sum2);
			
			if (sum2 > sum1) //if sum2 is greater than sum1, then set sum1 to be sum2
			{
				sum1 = sum2; //sum1 is always going to be the largest sum
				start = a; //indictaes the where the indexes with the lagest sum starts 
			}
	
		}
		
		return start;
	}
	
	public static void main(String[] args) 
	{
		
		int menu;
		
		do
		{
			System.out.println();
			System.out.println("0. Exit the program.");
			System.out.println("1. Populate the array randomly.");
			System.out.println("2. Populate the array sequentially from 1 to 100.");
			System.out.println("3. Display the array.");
			System.out.println("4. Shuffle the array.");
			System.out.println("5. Find number");
			System.out.println("6. Check if the array is in ascending order.");
			System.out.println("7. Sort the array in ascending order.");
			System.out.println("8. Find lowest number.");
			System.out.println("9. Find highest number.");
			System.out.println("10. Find number of occurances.");
			System.out.println("11. Switch occurances of 1st number with 2nd number.");
			System.out.println("12. 10 consecuitive indexes that have the greatest sum.");
			
			menu = errorTrap(0,12);
			
			if (menu == 1)
				populateRandomly();
			
			if (menu == 2)
				populateSequentially();
			
			if (menu == 3)
				displayArray();
			
			if (menu == 4)
				shuffleArray();
			
			if(menu == 5)
			{
				System.out.println("Enter a number: ");
				int index = findNumber(errorTrap(0,100));
				
				if (index > -1)
					System.out.println("The number is at index " + index);
				else
					System.out.println("The number is not in the list");

			}
			
			if(menu == 6)
			{
				boolean ascending = ascending();
				
				if (ascending == true)
					System.out.println("The list is in ascending order.");
				
				else
					System.out.println("The list is not in ascending order.");
			}
				
			if(menu == 7)
			{
				boolean ascending = sortAscending();
				
				if (ascending == true)
					System.out.println("The list is in ascending order.");
				
				else
					System.out.println("It took too long");
			}
				
			
			if(menu == 8)
				System.out.println("The lowest number is " + lowestNumber());
			
			if(menu == 9)
				System.out.println("The highest number is " + highestNumber());
			
			if(menu == 10)
			{
				System.out.print("Enter a number: ");
				int occurances = occurances(errorTrap(0,100));
				System.out.println(occurances + " occurance(s)");
			}
				
			if(menu == 11)
			{
				System.out.print("Number 1: ");
				int number1 = errorTrap(0,100);
				
				System.out.print("Number 2: ");
				int number2 = errorTrap(0,100);
				
				swap(number1, number2);
			}
			
			if(menu == 12)
			{
				int start = greatestSumIndexes();
				
				for (int a = start; a < ((SIZE/10) + start); a ++)//prints the indexes with the largest sum
				{
					System.out.print(manta[a] + " ");
				}
			}
			
		}while (menu != 0);
		
	}
	
}

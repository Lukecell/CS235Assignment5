import java.util.*;

public class DateTest
{
	public static void main(String []args)
	{
		Date [] arr = new Date[100];
		Random rand = new Random();

		for(int i = 0; i < arr.length; i++)
			arr[i] = new Date(rand.nextInt(11) + 1, rand.nextInt(29) + 1, rand.nextInt(600) + 1500);

		quickSort(arr);

		for(int i = 0; i < arr.length; i++)
			System.out.printf("(%d, %d, %d), ", arr[i].getDay(), arr[i].getMonth(), arr[i].getYear());
	}

	public static void quickSort(Comparable array[])
	{
		doQuickSort(array, 0, array.length - 1);
	}

	/**
		The doQuickSort method uses the QuickSort algorithm
		to sort an int array.
		@param array The array to sort.
		@param start The starting subscript of the list to sort
		@param end The ending subscript of the list to sort
	*/
	
	private static void doQuickSort(Comparable array[], int start, int end)
	{
		int pivotPoint;
		
		if (start < end)
		{
			// Get the pivot point.
			pivotPoint = partition(array, start, end);
			
			// Sort the first sub list.
			doQuickSort(array, start, pivotPoint - 1);
			
			// Sort the second sub list.
			doQuickSort(array, pivotPoint + 1, end);
		}
	}

	/**
		The partiton method selects a pivot value in an array
		and arranges the array into two sub lists. All the
		values less than the pivot will be stored in the left
		sub list and all the values greater than or equal to
		the pivot will be stored in the right sub list.
		@param array The array to partition.
		@param start The starting subscript of the area to partition.
		@param end The ending subscript of the area to partition.
		@return The subscript of the pivot value.
	*/
	
	private static int partition(Comparable array[], int start, int end)
	{
		Comparable pivotValue;	 // To hold the pivot value
		int endOfLeftList; // Last element in the left sub list.
		int mid;			  // To hold the mid-point subscript

		// Find the subscript of the middle element.
		// This will be our pivot value.
		mid = (start + end) / 2;

		// Swap the middle element with the first element.
		// This moves the pivot value to the start of 
		// the list.
		swap(array, start, mid);

		// Save the pivot value for comparisons.
		pivotValue = array[start];
		
		// For now, the end of the left sub list is
		// the first element.
		endOfLeftList = start;
		
		// Scan the entire list and move any values that
		// are less than the pivot value to the left
		// sub list.
		for (int scan = start + 1; scan <= end; scan++)
		{
			if (array[scan].compareTo(pivotValue) > 0)
			{
				endOfLeftList++;
				swap(array, endOfLeftList, scan);
			}
		}
		
		// Move the pivot value to end of the
		// left sub list.
		swap(array, start, endOfLeftList);
		
		// Return the subscript of the pivot value.
		return endOfLeftList;
	}

	/**
		The swap method swaps the contents of two elements
		in an int array.
		@param The array containing the two elements.
		@param a The subscript of the first element.
		@param b The subscript of the second element.
	*/
	
	private static void swap(Comparable[] array, int a, int b)
	{
		Comparable temp;
		
		temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

}

class Date implements Comparable<Date>
{
	private String month;
	private int day;
	private int year; //a four digit number.

	public Date( )
	{
		month = "January";
		day = 1;
		year = 1000;
	}

	public Date(int monthInt, int day, int year)
	{
		setDate(monthInt, day, year);
	}

	public Date(String monthString, int day, int year)
	{
		setDate(monthString, day, year);
	}

	public Date(int year) 
	{
		setDate(1, 1, year);
	}

	@Override
	public int compareTo(Date a)// throws NullPointerException
	{
		//if(a == null)
			//throw new NullPointerException("Invalid reference");

		if(this.getYear() != a.getYear())
			return (a.getYear() - this.getYear());

		if(this.getMonth() != a.getMonth())
			return (a.getMonth() - this.getMonth());

		if(this.getDay() != a.getDay())
			return (a.getDay() - this.getDay());

		return 0;
	}

	public void setDate(int monthInt, int day, int year)
	{
		if (dateOK(monthInt, day, year))
		{
			this.month = monthString(monthInt);
			this.day = day;
			this.year = year;
		}
		else
		{
			 throw new IllegalArgumentException("Bad date!");
			
  

		}
	}

	public void setDate(String monthString, int day, int year)
	{
		if (dateOK(monthString, day, year))
		{
			this.month = monthString;
			this.day = day;
			this.year = year;
		}
		else
		{
		
		   throw new IllegalArgumentException("Bad date!");
		  
		}
	}

	public void setDate(int year)
	{
		setDate(1, 1, year);
	}

	public void setYear(int year)
	{
		if ( (year < 1000) || (year > 9999) )
		{
		   throw new IllegalArgumentException("Bad year!");
			
		}
		else
			this.year = year;
	}
	public void setMonth(int monthNumber)
	{
		if ((monthNumber <= 0) || (monthNumber > 12))
		{
			throw new IllegalArgumentException("Bad month!");
			
 
		}
		else
			month = monthString(monthNumber);
	}

	public void setDay(int day)
	{
		if ((day <= 0) || (day > 31))
		{
			 throw new IllegalArgumentException("Bad day!");
			
 
		}
		else
			this.day = day;
	}

	public int getMonth( )
	{
		if (month.equals("January"))
			return 1;
		else if (month.equals("February"))
			return 2;
		else if (month.equalsIgnoreCase("March"))
			return 3;
		else if (month.equalsIgnoreCase("April"))
			return 4;
		else if (month.equalsIgnoreCase("May"))
			return 5;
		else if (month.equals("June"))
			return 6;
		else if (month.equalsIgnoreCase("July"))
			return 7;
		else if (month.equalsIgnoreCase("August"))
			return 8;
		else if (month.equalsIgnoreCase("September"))
			return 9;
		else if (month.equalsIgnoreCase("October"))
			return 10;
		else if (month.equals("November"))
			return 11;
		else if (month.equals("December"))
			return 12;
		else
		{
			throw new IllegalArgumentException("Bad month!");
			
 
		}
	}

	public int getDay( )
	{
		return day;
	}

	public int getYear( )
	{
		return year;
	}

   
  
	private boolean dateOK(int monthInt, int dayInt, int yearInt)
	{
		return ( (monthInt >= 1) && (monthInt <= 12) &&
				 (dayInt >= 1) && (dayInt <= 31) &&
				 (yearInt >= 1000) && (yearInt <= 9999) );
	}

	private boolean dateOK(String monthString, int dayInt, int yearInt)
	{
		return ( monthOK(monthString) &&
				 (dayInt >= 1) && (dayInt <= 31) &&
				 (yearInt >= 1000) && (yearInt <= 9999) );
	}

	private boolean monthOK(String month)
	{
		return (month.equals("January") || month.equals("February") ||
				month.equals("March") || month.equals("April") ||
				month.equals("May") || month.equals("June") ||
				month.equals("July") || month.equals("August") ||
				month.equals("September") || month.equals("October") ||
				month.equals("November") || month.equals("December") );
	}

	private String monthString(int monthNumber)
	{
		switch (monthNumber)
		{
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			 throw new IllegalArgumentException("Bad month number!");
			

		}
	}
}


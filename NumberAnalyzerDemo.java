import java.util.*;

public class NumberAnalyzerDemo
{
	public static void main(String []args)
	{
		Integer arr[] = new Integer[5];
		int []test1 = new int[1000000]; Random rand = new Random();
		//int []test2 = new int[1000000]; int []test3 = new int[1000000];


		for(int i = 0; i < test1.length; i++)
		{
			test1[i] = rand.nextInt(1000000 - 1) + 1;
			//test2[i] = test1[i];
			//test3[i] = test1[i];
		}
		long currentTime = System.currentTimeMillis();
		long previousTime;
		long elapsedTime = 0;

		System.out.printf("Starting test:\n");

		previousTime = currentTime;

		doQuickSort(test1, 0, 1000000 - 1);

		currentTime = System.currentTimeMillis();

		elapsedTime = (currentTime - previousTime)/1000;

		System.out.println("Computed in " + elapsedTime + " seconds.");

		arr[0]=1;arr[1]=2;arr[2]=3;arr[3]=4;arr[4]=5;
	}

   public static void bubbleSort(int[] array)
   {
		int lastPos;     // Position of last element to compare
		int index;       // Index of an element to compare
		int temp;        // Used to swap to elements
      
		// The outer loop positions lastPos at the last element
		// to compare during each pass through the array. Initially
		// lastPos is the index of the last element in the array.
		// During each iteration, it is decreased by one.
		for (lastPos = array.length - 1; lastPos >= 0; lastPos--)
		{
			// The inner loop steps through the array, comparing
			// each element with its neighbor. All of the elements
			// from index 0 thrugh lastPos are involved in the
			// comparison. If two elements are out of order, they
			// are swapped.
			for (index = 0; index <= lastPos - 1; index++)
			{
				// Compare an element with its neighbor
				if (array[index] > array[index + 1])
				{
					// Swap the two elements.
					temp = array[index];
					array[index] = array[index + 1];
					array[index + 1] = temp;
				}
			}
		}
	}

	   private static void doQuickSort(int array[], int start, int end)
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
   
   private static int partition(int array[], int start, int end)
   {
      int pivotValue;    // To hold the pivot value
      int endOfLeftList; // Last element in the left sub list.
      int mid;           // To hold the mid-point subscript

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
         if (array[scan] < pivotValue)
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
   
   private static void swap(int[] array, int a, int b)
   {
      int temp;
      
      temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }


   /**
      The selectionSort method performs a selection sort on an
      int array. The array is sorted in ascending order.
      @param array The array to sort.
   */

   public static void selectionSort(int[] array)
   {
      int startScan;   // Starting position of the scan
      int index;       // To hold a subscript value
      int minIndex;    // Element with smallest value in the scan
      int minValue;    // The smallest value found in the scan

      // The outer loop iterates once for each element in the
      // array. The startScan variable marks the position where
      // the scan should begin.
      for (startScan = 0; startScan < (array.length-1); startScan++)
      {
         // Assume the first element in the scannable area
         // is the smallest value.
         minIndex = startScan;
         minValue = array[startScan];
         
         // Scan the array, starting at the 2nd element in
         // the scannable area. We are looking for the smallest
         // value in the scannable area. 
         for(index = startScan + 1; index < array.length; index++)
         {
            if (array[index] < minValue)
            {
               minValue = array[index];
               minIndex = index;
            }
         }

         // Swap the element with the smallest value 
         // with the first element in the scannable area.
         array[minIndex] = array[startScan];
         array[startScan] = minValue;
      }
   }
}

class NumberAnalyzer <N extends Number & Comparable>
{
	public N findMin(N arr[])
	{
		int min = 0;

		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i].compareTo(arr[min]) < 0)
				min = i;
		}

		return arr[min];
	}

	public N convertInstanceOfObject(Object o) {
		try 
		{
			return (N) o;
		} catch (ClassCastException e) 
		{
			return null;
		}
	}

	public N findMax(N arr[])
	{
		int min = 0;

		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i].compareTo(arr[min]) > 0)
				min = i;
		}

		return arr[min];
	}

	public N findAvg(N arr[])
	{
		double total = 0;

		for(int i = 0; i < arr.length; i++)
			total = total + arr[i].doubleValue();

		total = total/arr.length;

		return convertInstanceOfObject(total);
	}

	public N findTotal(N arr[])
	{
		double total = 0;

		for(int i = 0; i < arr.length; i++)
			total = total + arr[i].doubleValue();

		return convertInstanceOfObject(total);
	}
}

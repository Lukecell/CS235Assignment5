class NumberAnalyzer <N extends Number & Comparable>
{
	/**
	* Finds the smallest value
	* @param N[] The array to be parsed
	* @return N The smallest value in the array
	*/

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

	/**
	* Converts an object to generic
	* @param Object The object to be converted
	* @return N The generic casted version
	*/

	public N convertInstanceOfObject(Object o) {
		try 
		{
			return (N) o;
		} catch (ClassCastException e) 
		{
			return Math.floor(o);
		}
	}

	/**
	* Finds the largest value
	* @param N[] The array to be parsed
	* @return N The largest value in the array
	*/

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

	/**
	* Calculates the arithmetic mean of an array
	* @param N[] The array analyzed
	* @return N The sum of all values divided by the total number of elements
	*/

	public N findAvg(N arr[])
	{
		double total = 0;

		for(int i = 0; i < arr.length; i++)
			total = total + arr[i].doubleValue();

		total = total/arr.length;

		return convertInstanceOfObject(total);
	}

	/**
	* Calculates the total sum of all elements in the array
	* @param N[] The array analyzed
	* @return N The sum of all elements in the array
	*/

	public N findTotal(N arr[])
	{
		double total = 0;

		for(int i = 0; i < arr.length; i++)
			total = total + arr[i].doubleValue();

		return convertInstanceOfObject(total);
	}
}

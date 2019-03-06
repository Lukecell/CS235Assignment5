import java.util.*;

class NumberAnalyzer <N extends Number & Comparable >
{
	private Class<N> typeOfN;

    public NumberAnalyzer(Class<N> typeParameterClass) {
        this.typeOfN = typeParameterClass;
    }

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
		Double total = new Double(0);

		for(int i = 0; i < arr.length; i++)
			total = total + arr[i].doubleValue();

		total = total/arr.length;

		try{
			return typeOfN.cast(total);
		}
		catch(ClassCastException e)
		{
			return typeOfN.cast(total.intValue());
		}
	}

	/**
	* Calculates the total sum of all elements in the array
	* @param N[] The array analyzed
	* @return N The sum of all elements in the array
	*/

	public N findTotal(N arr[])
	{
		Double total = new Double(0);

		for(int i = 0; i < arr.length; i++)
			total = total + arr[i].doubleValue();

        try{
            return typeOfN.cast(total);
        }
        catch(ClassCastException e)
        {
            return typeOfN.cast(total.intValue());
        }
	}
}

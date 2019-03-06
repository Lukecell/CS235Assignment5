public class NumberAnalyzerDemo
{
	public static void main(String args[])
	{
		Integer arr[] = new Integer[100];
		NumberAnalyzer <Integer>test = new NumberAnalyzer<>(Integer.class);

		for(int i = 0; i < arr.length; i++)
			arr[i] = i + 1;

		if(test.findMin(arr) == 1)
			System.out.printf("Test 1 Passed\n");
		else
			System.out.printf("Test 1 Failed\n");

		if(test.findMax(arr) == 100)
			System.out.printf("Test 2 Passed\n");
		else
			System.out.printf("Test 2 Failed\n");

		if(test.findTotal(arr) == 5050)
			System.out.printf("Test 3 Passed\n");
		else
			System.out.printf("Test 3 Failed\n");

		if(test.findAvg(arr) == 50)
			System.out.printf("Test 4 Passed\n");
		else
			System.out.printf("Test 4 Failed\n");
	}
}

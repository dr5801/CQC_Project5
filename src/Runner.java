import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

/**
 *
 * @author Drew Rife and Jordan Long
 *
 */
public class Runner
{
	private static WeakHashMap<WeakReference, List<Integer>> weakHashMap = new WeakHashMap<WeakReference, List<Integer>>();
	public static List<Integer> zeroToOneThousand = new ArrayList<Integer>();
	public static List<Integer> oneThousandToTenThousand = new ArrayList<Integer>();
	public static List<Integer> tenThousandToHundredThousand = new ArrayList<Integer>();
	public static List<Integer> hundredThousandToMillion = new ArrayList<Integer>();
	public static WeakReference<String> nameOfList;

	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.print("Printing Numbers ..... ");
		putNumbersInLists();
		System.out.println("Done");

		createExpensiveObjects();

		System.out.print("Writing to file");
		printAllValues();
		System.out.println("Done");
	}

	/**
	 * pointlessly create arraylist objects
	 */
	private static void createExpensiveObjects()
	{
		for(int i = 0; i < 999999999; i++)
		{
			ArrayList<Integer> array = new ArrayList<Integer>(1000000);
		}
//		for(int i = 0; i < 999999999; i++)
//		{
//			ArrayList<Integer> array = new ArrayList<Integer>(1000000);
//		}
//		for(int i = 0; i < 999999999; i++)
//		{
//			ArrayList<Integer> array = new ArrayList<Integer>(1000000);
//		}
//		for(int i = 0; i < 999999999; i++)
//		{
//			ArrayList<Integer> array = new ArrayList<Integer>(1000000);
//		}
	}

	/**
	 * puts all the values into a file
	 * @throws FileNotFoundException
	 */
	private static void printAllValues() throws FileNotFoundException
	{
		File file = new File("ListOfMillionNumbers.csv");

		if(file.exists())
		{
			file.delete();
		}

		PrintWriter writer = new PrintWriter(file);

		for(int runs = 0; runs < 10; runs++)
		{
			for(WeakReference reference : weakHashMap.keySet())
			{
				for(Integer number : weakHashMap.get(reference))
				{
					writer.append(number + ",");
				}
			}

			writer.append("\n");
		}

		writer.close();
	}

	/**
	 * puts the numbers into the lists
	 */
	private static void putNumbersInLists()
	{
		/* run for the first thousand */
		for(int i = 0; i < 1000; i++)
		{
			zeroToOneThousand.add(i);
		}

		nameOfList = new WeakReference<String>("Thousand");
		weakHashMap.put(nameOfList, zeroToOneThousand);

		/* run for the next ten thousand*/
		for(int i = 1000; i < 10000; i++)
		{
			oneThousandToTenThousand.add(i);
		}

		nameOfList = new WeakReference<String>("TenThousand");
		weakHashMap.put(nameOfList, oneThousandToTenThousand);

		/* run until hundred thousand */
		for(int i = 10000; i < 100000; i++)
		{
			hundredThousandToMillion.add(i);
		}

		nameOfList = new WeakReference<String>("HundredThousand");
		weakHashMap.put(nameOfList, tenThousandToHundredThousand);

		/* run until a million */
		for(int i = 100000; i < 1000000; i++)
		{
			hundredThousandToMillion.add(i);
		}

		nameOfList = new WeakReference<String>("Million");
		weakHashMap.put(nameOfList, hundredThousandToMillion);
	}

}

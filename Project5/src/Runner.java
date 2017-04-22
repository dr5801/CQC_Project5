import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/**
 *
 * @author Drew Rife and Jordan Long
 *
 */
public class Runner
{
	/* list of strings to use for the WeakHashMap */
	private static String[] listOfStrings = 
		{
				"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
		};

	public static void main(String[] args) throws FileNotFoundException
	{
		basicExampleOfWeakReference();
		exampleWithWeakHashMap();
	}

	/**
	 * example of using WeakHashMap
	 */
	private static void exampleWithWeakHashMap() 
	{
		WeakHashMap<String, Integer> weakHashMap = new WeakHashMap<String, Integer>();
		initializeWeakHashMap(weakHashMap);
		
		/* clear the listOfStrings */
		for(String string : listOfStrings)
		{
			string = null;
		}
		
		System.out.println("\nPart 2: Using WeakHashMap:");
		System.out.println("Values in WeakHashMap before garbage collection:");
		printValues(weakHashMap);
	}

	/**
	 * prints the values of the weak hashmap 
	 * @param weakHashMap
	 */
	private static void printValues(WeakHashMap<String, Integer> weakHashMap) 
	{
		for(String key : weakHashMap.keySet())
		{
			System.out.print("(" + key + "," + weakHashMap.get(key) + ") ");
		}
		
	}

	/**
	 * initializes the weakHashMap by filling it with the strings of numbers and the number associated with it
	 * @param weakHashMap
	 */
	private static void initializeWeakHashMap(WeakHashMap<String, Integer> weakHashMap) 
	{
		int number = 1;
		for(String numberString : listOfStrings)
		{
			weakHashMap.put(numberString, number++);
		}
	}

	/**
	 * basic example of using a weakreference object
	 */
	private static void basicExampleOfWeakReference() 
	{
		WeakReference<String> basicString = new WeakReference<String>(new String("This is a weak referenced string"));
		
		System.out.println("Part 1: Using WeakReference with String:");
		System.out.println("WeakReference String : " + basicString.get());
		while(basicString.get() != null)
		{
			ArrayList<Integer> expensiveObject = new ArrayList<Integer>(10);
		}
		
		System.out.println("Garbage collection occurred, WeakReference String : " + basicString.get());
	}
}
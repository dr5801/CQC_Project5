import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
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
		WeakHashMap<WeakReference<String>, WeakReference<Integer>> weakHashMap = new WeakHashMap<WeakReference<String>, WeakReference<Integer>>();
		initializeWeakHashMap(weakHashMap);
		
		System.out.println("\nPart 2: Using WeakHashMap:");
		System.out.println("Values in WeakHashMap before garbage collection:");
		printValues(weakHashMap);
		
		System.gc();
		
		System.out.println("\nGarbage collection occurred, WeakHashMap keys : ");
		for(String numberString : listOfStrings)
		{
			String key = null;
			
			/* if the key exists, set the string key to the key */
			if(weakHashMap.containsKey(numberString))
			{
				key = numberString;
			}
			
			System.out.print("(" + key + "," + weakHashMap.get(key) + ") ");
		}
	}

	/**
	 * prints the values of the weak hashmap 
	 * @param weakHashMap
	 */
	private static void printValues(WeakHashMap<WeakReference<String>, WeakReference<Integer>> weakHashMap) 
	{
		for(WeakReference<String> key : weakHashMap.keySet())
		{
			System.out.print("(" + key.get() + "," + weakHashMap.get(key).get() + ") ");
		}
	}

	/**
	 * initializes the weakHashMap by filling it with the strings of numbers and the number associated with it
	 * @param weakHashMap
	 */
	private static void initializeWeakHashMap(WeakHashMap<WeakReference<String>, WeakReference<Integer>> weakHashMap) 
	{
		int number = 1;
		for(String numberString : listOfStrings)
		{
			WeakReference<Integer> weakInteger = new WeakReference<Integer>(new Integer(number));
			WeakReference<String> weakString = new WeakReference<String>(new String(numberString));
			weakHashMap.put(weakString, weakInteger);
			number++;
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
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 *
 * @author Drew Rife and Jordan Long
 *
 */
public class Runner
{
	public static WeakReference<String> nameOfList;

	public static void main(String[] args) throws FileNotFoundException
	{
		basicExampleOfWeakReference();
		exampleWithWeakHashMap();
	}

	private static void exampleWithWeakHashMap() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * basic example of using a weakreference object
	 */
	private static void basicExampleOfWeakReference() 
	{
		WeakReference<String> basicString = new WeakReference<String>(new String("WeakReferenced String"));
		
		System.out.println("WeakReference String -> : " + basicString.get());
		while(basicString.get() != null)
		{
			ArrayList<Integer> expensiveObject = new ArrayList<Integer>(10);
		}
		
		System.out.println("Garbage collection occurred, WeakReference String -> : " + basicString.get());
	}
}
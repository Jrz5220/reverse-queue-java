
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Use recursion to reverse a list of names entered by the user.
 */
public class ReverseQueue {
	
	public static void main(String args[]) {
		
		String name = "";
		int numOfNames = 0;
		Scanner scan = new Scanner(System.in);
		Queue<String> names = new LinkedList<>();

		System.out.println("Enter names into a list.\nHow many names do you want to enter?");
		
		while(true) {
			numOfNames = getUserNum(scan);
			if(numOfNames <= 0 || numOfNames > 20)
				System.out.println("Only 1-20 names allowed. Please try again.");
			else
				break;
		}
		
		addNamesToQueue(scan, name, names, numOfNames);
		
		System.out.println("The names you entered: ");
		for(String n : names) {
			System.out.println(n);
		}
		
		reverseQueue(name, names);
		
		System.out.println("\nList of names in reverse order: ");
		for(String n : names) {
			System.out.println(n);
		}
		
		scan.close();
		
	} //end main
	
	public static int getUserNum(Scanner sc) {
		try {
			String input = sc.nextLine().trim().replaceAll("\\s+", "");
			int num = Integer.parseInt(input);
			return num;
		} catch(NumberFormatException e) {
			System.out.println("Invalid number. Try again.");
			return getUserNum(sc);
		}
	} //end getUserNum

	public static void addNamesToQueue(Scanner sc, String theName, Queue<String> nameQueue, int numberOfNames) {
		if(numberOfNames >= 1) {
			System.out.println("Enter a name: ");
			theName = sc.nextLine().trim().replaceAll("\\s+", "-");
			nameQueue.add(theName);
			addNamesToQueue(sc, theName, nameQueue, numberOfNames - 1);
		}
	} //end addNamesToQueue
	
	public static void reverseQueue(String theName, Queue<String> nameQueue) {
		if(!nameQueue.isEmpty()) {
			theName = nameQueue.remove();
			reverseQueue(theName, nameQueue);
			nameQueue.add(theName);
		}
	} //end reverseQueue
	
} //end ReverseQueue

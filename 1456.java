import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;


/**
* Description:
*
* Your little friend Lily is playing with some numbers (here "some" means up to 1000001 integers) and even when she knows there is exactly one number in the list which appears only once, and the others appears twice at most, she still takes too long on finding the answer for this question:  what's value of the single element in the list? By "single" we mean the element appearing only once in the list. Please help Lily with your awesome coding skills.
* Input specification
* First line says the N which is the length of the given list (1 <= N <= 1000001). N lines follow each one with a single integer from the list. Integers from the list are in the range [1, 10^9].
* Output specification
*
* A single integer with the required remainder.
* Sample input:
*
* 3
* 1
* 10
* 1
* Sample output:
*
* 10
* Hint(s)
*
* N is in the form 2*K + 1, 0 <= K <= 500000.
*
* Problem number: 1456
*
* @author Guido J. Celada (celadaguido@gmail.com)
**/
public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		int n, num, key;
		
		Hashtable<Integer,Integer> hashTable = new Hashtable<Integer,Integer>();
		n = Integer.parseInt(in.readLine()); 
		for(int i = 0; i < n; i++){		
			num = Integer.parseInt(in.readLine());
			if (hashTable.containsKey(num))
				hashTable.put(num, hashTable.get(num)+1);
			else
				hashTable.put(num, 1);
		}
		
		Enumeration<Integer> keys = hashTable.keys();
		while (keys.hasMoreElements()){
			key = keys.nextElement();
			if (hashTable.get(key) == 1){
				System.out.println(key);
				break;
			}
		}
	}

}


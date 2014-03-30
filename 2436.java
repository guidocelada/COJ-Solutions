import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
* Description
* 
* Today is your first working day at INSILICO institute (INstitute of Several Investigations of Languages and the Immense COsmo)), this institute is in charge of analyzing messages coming from extraterrestrial societies, light years away. During a long time many messages have been collected, studied and translated. However, some messages are very confusing and don't have a direct translation. These are assigned to new members of the institute so they can have some fun.
*
* After some time, you have discovered that before doing a translation, you have to do a decoding, where you must change the message characters for others of the same language. More specifically, the character which repeats the most in the message is always replaced with the most repeated one in the language. The second character which repeats the most is replaced with the second most repeated one in the language, and so on. You have the task of doing a program to make this conversion.
* Input specification
* 
* The first input line has an integer T, which indicates the number of test cases (1 <= T <= 50). Each test case has 3 lines. The first line has two integers N and M, representing the number of characters in that language (1 <= N <= 26) and the size of the message (1 <= M <= 100). The second line has N different capital letters from the Latin alphabet, separate by a space, which represent the characters of the extraterrestrial language, ordered increasingly by their frequency in the language. The third line has the message which must be decoded. No pair of characters will appear the same number of time in a message, and the message will only have characters from the given extraterrestrial language.
* Output specification
* 
* For each test case print in one single line the decoded message.
* Sample input
* 
* 3
* 4 3
* M B P N
* PNP
* 4 11
* A B C D
* DCDBACDBDCD
* 4 11
* A B C D
* ABACDBACABA
* Sample output
*
* MBM
* ABACDBACABA
* ABACDBACABA
*
* Problem number: 2436
*
* @author Guido J. Celada (celadaguido@gmail.com)
**/
public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));


	public static void main(String[] args) throws Exception{
		int n;
		String readed, message;
		String[] alphabet;
		char character;
		
		n = Integer.parseInt(in.readLine()); 
		
		for(int i = 0; i < n; i++){		
			
			Map<Character,Integer> map = new HashMap<Character,Integer>();
			
			in.readLine(); //omit first number
			
			readed = in.readLine();//alphabet
			alphabet = readed.split(" "); 
			
			message = in.readLine();//sentence to decode
			for (int j = 0; j < message.length(); j++){
				character = message.charAt(j);
				if (map.containsKey(character))
					map.put(character, map.get(character)+1);
				else
					map.put(character, 1);
			}
			
			List<Map.Entry<Character,Integer>> list = new LinkedList<Map.Entry<Character,Integer>>(map.entrySet()); //create list to sort 
			//sort the values of the list by the values of the map 
			Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
				public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2){
					return entry1.getValue().compareTo(entry2.getValue());
				} 
			});
			Collections.reverse(list);
			
			HashMap<Character,String> hashMap = new HashMap<Character,String>();
			int index = 0;
			for (Map.Entry<Character, Integer> entry : list){
				hashMap.put(entry.getKey(), alphabet[index]);
				index++;
			}
			
			for (int j = 0; j < message.length(); j++){
				System.out.print(hashMap.get(message.charAt(j)));
			}
			System.out.println();
		}
	}
}

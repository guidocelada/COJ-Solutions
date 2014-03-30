import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
* Description
*
* Ana is a Sixth Semester Mathematics student at Pereira's Technological University, Ana was contacted by CCI (Cryptographers Colombian Institute) to help them to solve problem. The problem is calculating the primorial of N for some numbers. The primorial of number N is defined as the product of all primes equal or less than N. 
* Input specification
*
* The input consists several lines, with a positive whole number N at each one of them, indicating the number for which the primorial will be calculated, 2 <= N <= 50. The Input concludes with a line containing the number 0, for which the program must do nothing, just finalize.
* Output specification
*
* For each input case, your program must print a single line with just a positive whole number: the primorial of the given number N.
* Sample input
*
* 2
* 7
* 10
* 11
* 19
* 0
* Sample output
*
* 2
* 210
* 210
* 2310
* 9699690
*
* Problem number: 2432
*
* @author Guido J. Celada (celadaguido@gmail.com)
**/
public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		
		int n = Integer.parseInt(in.readLine()); 
		String readed;
		String[] readedArray;
		long[] longArray;
		
		while (n != 0){
			longArray = new long[n];
			readed = in.readLine();
			readedArray = readed.split(" "); 
			
			for (int i = 0; i < n; i++){ //create array of longs with the read numbers
				longArray[i] = Long.parseLong(readedArray[i]);
			}
			
			Arrays.sort(longArray); //o(log n)
			
			if (n%2 == 0){ //even length
				System.out.println(String.format("%.1f",(double) (longArray[n/2] + longArray[(n/2) -1]) / 2).replace(",","."));
			} else{ //odd length
				System.out.println(String.format("%.1f",(double) longArray[n/2]).replace(",","."));
			}
			
			n = Integer.parseInt(in.readLine());
		}
		
		
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
* Description
*
* Betty likes integer–number mathematics, and knows that calculating something like a^b can produce rather large results when a and b are suﬃciently big. Furthermore, Betty is only interested in knowing the last 9 digits from a^b. For this reason, she has hired you, a member of the Union for Tremendous Powers (UTP), to tell her the 9 least signiﬁcant digits from the exponentiation.
* Input specification
*
* Input consists of many test cases. The ﬁrst line contains the number of test cases 1 <= T <= 10000, and each of the following T lines represents a single test case, containing 2 integers: a and b, with 1 <= a,b <= 10^9.
*
* Output specification
*
* For each test case given in the input, you must print the 9 least signiﬁcant digits from the exponentiation (without zeroes to the left), on a single line.
* Sample input
*
* 5
* 2 2
* 2 3
* 3 2
* 1001 1000
* 1000000000 1
* Sample output
*
* 4
* 8
* 9
* 501000001
* 0
*
* Problem number: 2422
*
* @author Guido J. Celada (celadaguido@gmail.com)
**/
public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		int n;
		String readed;
		String[] readedArray;
		BigInteger exponent;
		String s = "1000000000";
		BigInteger result;
		BigInteger last = new BigInteger(s);

		n = Integer.parseInt(in.readLine());
		for(int i = 0; i < n; i++){			
				readed = in.readLine();
				readedArray = readed.split(" "); 
				s = readedArray[0];
				result = new BigInteger(s); //base
				s = readedArray[1];
				exponent = new BigInteger(s); //exponent
				result = result.modPow(exponent, last);
				System.out.println(result);
		}
		
			
	}

}

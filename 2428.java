import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
* http://coj.uci.cu/24h/problem.xhtml?abb=2428
*
* Problem number: 2428
*
* @author Guido J. Celada (celadaguido@gmail.com)
**/
public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(in.readLine());
		while (n != 0){
			System.out.println((int) Math.ceil(Math.sqrt(n)));
			n = Integer.parseInt(in.readLine());
		}
	}

}

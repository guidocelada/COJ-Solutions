import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
*
* Description
* You are in the world of mathematics to solve the great "Monkey Banana Problem". It states that, a monkey enters into a diamond shaped two dimensional array and can jump in any of the adjacent cells down from its current position (see figure). While moving from one cell to another, the monkey eats all the bananas kept in that cell. The monkey enters into the array from the upper part and goes out through the lower part. Find the maximum number of bananas the monkey can eat.
*
* Input specification
*
* Input starts with an integer T (1 <= T <= 50), denoting the number of test cases.
* Every case starts with an integer N (1 <= N <= 100). It denotes that, there will be 2*N - 1 rows. The ith (1 <= i <= N) line of next N lines contains exactly i numbers. Then there will be N - 1 lines. The jth (1 <= j < N) line contains N - j integers. Each number is greater than zero and less than 2^15.
* Output specification
*
* For each case, print the case number and maximum number of bananas eaten by the monkey.
* Sample input
*
* 2 
* 4
* 7
* 6 4
* 2 5 10
* 9 8 12 2
* 2 12 7
* 8 2
* 10
* 2
* 1
* 2 3
* 1
* Sample output
*
* Case 1: 63
* Case 2: 5
* Problem number: 1861
*
* @author Guido J. Celada (celadaguido@gmail.com)
**/
public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		int n;
		int rows;
		int cantNodos;
		int index;
		String readed;
		String[] readedArray;
		int[][] weights;
		long[][] distances;
		long maxPredecessor;
		
		
		n = Integer.parseInt(in.readLine()); //n = ammount of test cases
		for(int i = 0; i < n; i++){			
			rows = (Integer.parseInt(in.readLine()) * 2) - 1; //ammount of rows	
			cantNodos = (rows + 1) / 2; 
			cantNodos = cantNodos * cantNodos;
			cantNodos++;
			
			weights = new int[rows][cantNodos+1]; //FIX THIS - not essential 
			
			for(int j = 0; j < rows; j++){ // initialize weights of each node for each row
				index = 1;
				readed = in.readLine();
				readedArray = readed.split(" "); 
				for (String s : readedArray){
					weights[j][index] = Integer.parseInt(s);
					index++;
				}
			}
			
			distances = new long[rows][cantNodos+1];
			if (cantNodos > 0){
				distances[0][1] = weights[0][1];
				
				for (int row = 1; row < rows; row++){ 
					for(int nodo = 1; nodo < cantNodos; nodo++){
						if (weights[row][nodo] > 0){ //if node exists
							//pick the greatest of the distances of the predecessors and add my weight (i-th)				
							if (row <= rows/2)
								maxPredecessor = Math.max(distances[row-1][nodo-1], distances[row-1][nodo]);
							else
								maxPredecessor = Math.max(distances[row-1][nodo], distances[row-1][nodo+1]);
							distances[row][nodo] = weights[row][nodo] + maxPredecessor;
						}
					}
				}
			}
			System.out.println("Case "+(i+1)+": "+distances[rows-1][1]);
		}
		
			
	}

}


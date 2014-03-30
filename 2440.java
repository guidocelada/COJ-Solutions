import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
* Description
*
* Deoxyribonucleic acid (DNA) is a molecule that encodes the genetic instructions used in the development and functioning of all known living organisms and many viruses. Along with RNA and proteins, DNA is one of the three major macromolecules essential for all known forms of life. Genetic information is encoded as a sequence of nucleotides (guanine, adenine, thymine, and cytosine) recorded using the letters G, A, T, and C. Most DNA molecules are double-stranded helices, consisting of two long polymers of simple units called nucleotides, molecules with backbones made of alternating sugars (deoxyribose) and phosphate groups (related to phosphoric acid), with the nucleobases (G, A, T, C) attached to the sugars. DNA is well-suited for biological information storage, since the DNA backbone is resistant to cleavage and the double-stranded structure provides the molecule with a built-in duplicate of the encoded information.
* 
* For clarity, let's say that a DNA chain can be written as a sequence of nucleobases, eg. "AGCCTC".
*
* Scientifics of UTP have hired you to accomplish the following task: given two chains of DNA, M and N, your job is to decide whether M could have been generated from N. A chain M can be generated from a chain N, if it is possible to obtain M just by adding zero or most nucleobases either to the left or right of chain N. Additionally, as UTP is obsessed with thymine, they say that in order for M to be generated from N, M must have at least one thymine.
* Input specification
*
* The first line contains an integer T (1 <= T <= 1000) which specifies the number of test cases. Followed by T lines, each one contains two DNA chains M and N separated by a single space, both with no more than 60 nucleobases.
* Output specification
*
* For each input case print the letter "Y" (quotes for clarity) if the string M can be generated from N, otherwise print "N" (quotes for clarity).
* Sample input
*
* 6
* AGACT AC
* AGACG AC
* ATTTTACA ACA
* ACAGGCT ACA
* T T
* T A
* Sample output
*
* Y
* N
* Y
* Y
* Y
* N
*
* Problem number: 2440
*
* @author Guido J. Celada (celadaguido@gmail.com)
**/
public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		Integer numOfTestCases = Integer.parseInt(in.readLine());
		String M,N,MN;
		String[] NMArray;
		for (int i=0; i<numOfTestCases; i++){
			MN = in.readLine();
			NMArray = MN.split(" ");
			M = NMArray[0];
			N = NMArray[1];

			if (M.contains("T") && M.contains(N)) 
				System.out.println('Y');
			else
				System.out.println('N');
		}
	}

}

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
* Description
*
* A uniqword is a non-empty word containing only capital letters between 'A' and 'Z'. Also uniqword is lexicographically sorted and contain each letter at most one time. This time we need to compare two uniqwords.
* Input specification
*
* Two lines, each one containing a uniqword for the comparison.
* Output specification
*
* The first line contain the lexicographically sorted list of letters in the first uniqword but not in the second one.
* The second line contain the lexicographically sorted list of letters in the second uniqword but not in the first one.
* The third and last line contain the lexicographically sorted list of letters in the first uniqword and also in the second one (common letters).
* See the sample output format, for more details.
* Sample input
*
* ABDFTY
* CDFXYZ
* Sample output
*
* First:ABT
* Second:CXZ
* First&Second:DFY
*
* Problem number: 2700
*
* @author Guido J. Celada (celadaguido@gmail.com)
**/
public class Main {
    
    static Scanner in = new Scanner(System.in);
    static HashMap<Character, Integer> ocurrences = new HashMap<>();
    static String s1 = "First:";
    static String s2 = "Second:";
    static String s3 = "First&Second:";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        
        char[] charArray1 = in.nextLine().toCharArray();
        for (char c : charArray1) {
            getAndPut(c);
        }
        
        char[] charArray2 = in.nextLine().toCharArray();
        for (char c : charArray2) {
            Integer cOcurrences = getAndPut(c);
            if (cOcurrences == 2) 
                s3 += c;
            else 
                s2 += c;
        }
        
        for (char c : charArray1) {
            if (ocurrences.get(c) == 1)
                s1 += c;
        }
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        
        //printHashMap(); //Debug
    }
   
    //puts the number of ocurrences for char c
    //returns the number of ocurrences
    public static Integer getAndPut(char c) {
        Integer cOcurrences = ocurrences.get(c);
        
        if (cOcurrences == null) {
            ocurrences.put(c, 1);
            cOcurrences = 0;
        }else {
            ocurrences.put(c, cOcurrences + 1);
        }
        cOcurrences++;
        return cOcurrences;
    }
    
    
    //Debug
    public static void printHashMap() {
        System.out.println("HashMap: ");
        for (Character c: ocurrences.keySet()) {
            System.out.println(c +": " + ocurrences.get(c));
        }
    }
}

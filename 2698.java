import java.util.Scanner;

/**
* Description
*
* Numbers can be represented with words. A easy way is as follow:
* Assign value 1 to ´A´, value 2 to ´B´, value 3 to ´C´, ..., value 25 to ´Y´ and value 26 to ´Z´.
* Sum the values of all letters composing the word you want to become a number.
* The result of the sum, is the number represented by the word.
* In that form ABC is equal to 6, AB is equal to 3, and Z is equal to 26. Note that numbers can be represented with more than one word. For example, the number 3 can be represented with C, AB, BA and AAA.
*
* A non-empty word of at most 26 capital letters between 'A' and 'Z' will be given, and you have to find the number which is represented by the word.
*
* Input specification
*
* A string of at most 26 letters, which represents one number.
* Output specification
*
* The number which is represented by the given word.
* Sample input
*
* COJ
* Sample output
* 
* 28
*
* Problem number: 2698
*
* @author Guido J. Celada (celadaguido@gmail.com)
**/
public class Main {

    static Scanner in = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = in.nextLine();
        char [] charArray = s.toCharArray();
        int total = 0;
        for (char c : charArray) 
            total += ((int) c) - 64;

        System.out.println( total );
    }
}

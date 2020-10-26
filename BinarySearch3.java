/*************************************************************************
 *  Compilation:  javac BinarySearch.java
 *  Execution:    java BinarySearch whitelist.txt < input.txt
 *************************************************************************/
//import java arrays library here we use it to sort array
import java.util.Arrays;


//Declaring a class with the name of file "BinarySearch3" in which whole code is save with .java extension
public class BinarySearch3 
{

  
    //int is data type and rank is the method name  
    public static int rank(int key, int[] a)
     {
       // this shows the starting index of array 
       int lo = 0;
          // this store the highest index of array which is one less from length
        int hi = a.length - 1;
         //first condition to check array has any integara or empty
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument. Reads in integers from standard input and
     * prints to standard output those integers that do *not* appear in the file.
     */
    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
}
package Math;

import java.util.ArrayList;

/**
 * Given a positive integer A, return an array of strings with all the integers from 1 to N.
 * But for multiples of 3 the array should have “Fizz” instead of the number.
 * For the multiples of 5, the array should have “Buzz” instead of the number.
 * For numbers which are multiple of 3 and 5 both, the array should have “FizzBuzz” instead of the number.
 *
 * Look at the example for more details.
 *
 * Example
 *
 * A = 5
 * Return: [1 2 Fizz 4 Buzz]
 */
public class FizzBuzz {

    /**
     * Simplest solution, running in O(n) time, pretty self-explanatory
     */
    public static ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> result = new ArrayList<>();

        for(int i=1; i<=A; i++) {
            StringBuilder current = new StringBuilder();
            if(i%3==0)
                current.append("Fizz");
            if(i%5==0)
                current.append("Buzz");
            if(current.length()==0)
                current.append(i);
            result.add(current.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        int A = 5;
        System.out.println(fizzBuzz(A).toString());
    }
}

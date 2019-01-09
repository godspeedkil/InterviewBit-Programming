package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindDuplicateInArray {

    public static int repeatedNumber(final List<Integer> a) {
        HashSet previous = new HashSet();

        for(int i=0; i<a.size(); i++) {
            if(!previous.add(a.get(i)))
                return a.get(i);
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(3, 4, 1,
         4, 1));
        System.out.println(repeatedNumber(arrayList));
    }
}

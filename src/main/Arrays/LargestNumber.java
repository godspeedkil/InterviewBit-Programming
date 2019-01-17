package Arrays;

import java.lang.reflect.Array;
import java.util.*;

public class LargestNumber {

    public static String largestNumberNaive(final List<Integer> A) {
        String[] strings = new String[A.size()];
        for(int i=0; i<A.size(); i++)
            strings[i] = "" + A.get(i);

        Arrays.sort(strings);

        StringBuilder largest = new StringBuilder();

        for(int i=A.size()-1; i>=0; i--) {
            largest.append(strings[i]);
        }

        return largest.toString();
    }

    public static String largestNumber(final List<Integer> A){
        Vector<String> strings = new Vector<>();
        for(int i=0; i<A.size(); i++)
            strings.add(A.get(i).toString());

        Collections.sort(strings, new Comparator<String>(){

            @Override
            public int compare(String X, String Y) {

                String XY=X + Y;

                String YX=Y + X;

                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        Iterator it = strings.iterator();

        StringBuilder result = new StringBuilder();

        while(it.hasNext()) {
            String current = (String)it.next();
            if(Integer.parseInt(current) != 0 || !it.hasNext())
                result.append(current);
        }

        return result.toString();
    }

    public static void main(String[] args) {
//        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(3, 30,
//                34, 5, 9));
//        System.out.println(largestNumber(arrayList1));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(0, 0, 0
                , 0, 0));
        System.out.println(largestNumber(arrayList2));
    }
}

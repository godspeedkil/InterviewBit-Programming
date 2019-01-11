package Math;


/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 *
 * Example:
 *
 *     A -> 1
 *
 *     B -> 2
 *
 *     C -> 3
 *
 *     ...
 *
 *     Z -> 26
 *
 *     AA -> 27
 *
 *     AB -> 28
 */
public class ExcelColumnNumber {

    /**
     * Problem becomes easy O(n) solution that is bounded by the maximum
     * limit of cells, once you realize this is just a base conversion to
     * base 26 (A to Z).
     */
    public static int titleToNumber(String A) {
        int num = 0;
        for(int i=A.length(); i>0; i--) {
            int offset = A.charAt(i-1)-('A'-1);
            num += Math.pow(26, A.length()-i) * offset;
        }
        return num;
    }

    public static void main(String[] args) {
        String A = "A";
        String Z = "Z";
        String AA = "AA";
        String AZ = "AZ";
        String SZ = "SZ";
        String CUZ = "CUZ";
        String NTP = "NTP";
        System.out.println(titleToNumber(A));
        System.out.println(titleToNumber(Z));
        System.out.println(titleToNumber(AA));
        System.out.println(titleToNumber(AZ));
        System.out.println(titleToNumber(SZ));
        System.out.println(titleToNumber(CUZ));
        System.out.println(titleToNumber(NTP));
    }
}

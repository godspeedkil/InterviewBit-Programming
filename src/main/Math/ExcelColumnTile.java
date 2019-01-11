package Math;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 */
public class ExcelColumnTile {

    /**
     * Solution is simple base conversion, which is O(n) for as many
     * characters we may have to put. Trick here is being careful with the
     * indices, since the Excel format is NOT zero-based, while decimal
     * system is, which is why we must do A-1.
     **/
    public static String convertToTitle(int A) {
        StringBuilder result = new StringBuilder();
        while(A>0) {
            int offset = (A-1) % 26;
            result.insert(0, (char)('A' + offset));
            A = (A-1) / 26;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(520));
        System.out.println(convertToTitle(10000));
    }
}

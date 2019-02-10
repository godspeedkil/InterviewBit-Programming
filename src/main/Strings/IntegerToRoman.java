package Strings;

/**
 * Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example :
 *
 * Input : 5
 * Return : "V"
 *
 * Input : 14
 * Return : "XIV"
 */
public class IntegerToRoman {

    private static StringBuilder addDigit(StringBuilder A, char ch, int n) {
        for (int i=0; i<n; i++) {
            A.append(ch);
        }
        return A;
    }

    /**
     * Unlike the RomanToInt program, it's easier to just work with cases for
     * this solution, since our range is considerably small (1 to 3999). Had
     * our range been bigger another solution might be needed.
     */
    public static String intToRoman(int A) {
        StringBuilder result = new StringBuilder();

        while (A!=0) {
            if (A>=1000) {
                result = addDigit(result, 'M', A/1000);
                A %= 1000;
            }
            else if (A>=500) {
                if (A<900) {
                    result = addDigit(result, 'D', A/500);
                    A %= 500;
                }
                else {
                    result.append("CM");
                    A %= 100;
                }
            }
            else if (A>=100) {
                if (A<400) {
                    result = addDigit(result, 'C', A/100);
                    A %= 100;
                }
                else {
                    result.append("CD");
                    A %= 100;
                }
            }
            else if (A>=50) {
                if (A<90) {
                    result = addDigit(result, 'L', A/50);
                    A %= 50;
                }
                else {
                    result.append("XC");
                    A %= 10;
                }
            }
            else if (A>=10) {
                if (A<40) {
                    result = addDigit(result, 'X', A/10);
                    A %= 10;
                }
                else {
                    result.append("XL");
                    A %= 10;
                }
            }
            else if (A>=5) {
                if (A<9) {
                    result = addDigit(result, 'V', A/5);
                    A %= 5;
                }
                else {
                    result.append("IX");
                    A = 0;
                }
            }
            else if (A>=1) {
                if (A<4) {
                    result = addDigit(result, 'I', A);
                    A = 0;
                }
                else {
                    result.append("IV");
                    A = 0;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
        System.out.println(intToRoman(3333));
    }
}

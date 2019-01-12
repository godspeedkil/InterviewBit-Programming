package Math;

public class GreatestCommonDivisor {

    public static int gcd(int A, int B) {
        if(A==0) return B;
        if(B==0) return A;
        int greaterNum = (A>B) ? A : B;
        int lowerNum = (greaterNum==A) ? B : A;

        for(int i=lowerNum; i>1; i--) {
            if((lowerNum%i==0) && (greaterNum%i==0))
                return i;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(gcd(25, 50));
        System.out.println(gcd(500, 120938));
        System.out.println(gcd(2, 2));
        System.out.println(gcd(286, 247));
        System.out.println(gcd(69, 23));
    }
}

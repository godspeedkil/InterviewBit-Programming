package Strings;

/**
 * Compare two version numbers version1 and version2.
 *
 * If version1 > version2 return 1,
 * If version1 < version2 return -1,
 * otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
public class CompareVersionNumbers {

    /**
     * There are many ways to extract every specific subset of versions. The
     * only real problem here is making sure you take into account version
     * numbers that have an additional subversion vs those that don't. (e.g.,
     * 1.13 vs 1.13.4).
     */
    public static int compareVersion(String A, String B) {
        int indexA = 0, indexB = 0;

        while (indexA<A.length() && indexB<B.length()) {
            StringBuilder currentA = new StringBuilder();
            StringBuilder currentB = new StringBuilder();
            while (indexA<A.length() && A.charAt(indexA)!='.') {
                currentA.append(A.charAt(indexA));
                indexA++;
            }
            while (indexB<B.length() && B.charAt(indexB)!='.') {
                currentB.append(B.charAt(indexB));
                indexB++;
            }
            indexA++;
            indexB++;
            long currentALong = Long.parseLong(currentA.toString());
            long currentBLong = Long.parseLong(currentB.toString());
            if (currentALong<currentBLong)
                return -1;
            else if (currentALong>currentBLong)
                return 1;
        }

        if (indexA>=A.length() && indexB<B.length())
            return -1;
        else if (indexA<A.length())
            return 1;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.13", "1.13.4"));
        System.out.println(compareVersion("4444371174137455", "5.168"));
    }
}

package Hashing;

import java.util.*;

/**
 * Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.
 *
 *  Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
 *  Note: All inputs will be in lower-case.
 * Example :
 *
 * Input : cat dog god tca
 * Output : [[1, 4], [2, 3]]
 * cat and tca are anagrams which correspond to index 1 and 4.
 * dog and god are another set of anagrams which correspond to index 2 and 3.
 * The indices are 1 based ( the first element has index 1 instead of index 0).
 *
 *  Ordering of the result : You should not change the relative ordering of the words / phrases within the group. Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j
 */
public class Anagrams {

    /**
     * My solution is based on building char count sets (as maps), then simply compare between
     * all of them in order to construct the solution groups.
     */
    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<HashMap<Character, Integer>> charCounts = new ArrayList<>();

        for (String word : A) {
            HashMap<Character, Integer> currCount = new HashMap<>();
            for (int i=0; i<word.length(); i++) {
                if (currCount.containsKey(word.charAt(i))) {
                    int temp = currCount.remove(word.charAt(i));
                    currCount.put(word.charAt(i), temp+1);
                }
                else
                    currCount.put(word.charAt(i), 1);
            }
            charCounts.add(currCount);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i=0; i<charCounts.size(); i++) {
            if (charCounts.get(i)!=null) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i + 1);
                for (int j = i + 1; j < charCounts.size(); j++) {
                    if (charCounts.get(i).equals(charCounts.get(j)))
                        temp.add(j + 1);
                }
                for (int j = temp.size() - 1; j >= 0; j--) {
                    charCounts.set(temp.get(j)-1, null);
                }
                result.add(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("cat", "dog", "god",
                "tca"));
        System.out.println(anagrams(arrayList1));
        ArrayList<String> arrayList2 =
                new ArrayList<>(Arrays.asList(
                        "abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba”, “abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa”, “babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"));
        System.out.println(anagrams(arrayList2));
    }
}

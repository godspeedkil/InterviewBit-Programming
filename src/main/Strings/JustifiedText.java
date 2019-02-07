package Strings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 *
 * Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Your program should return a list of strings, where each string represents a single line.
 *
 * Example:
 *
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 *
 * L: 16.
 *
 * Return the formatted lines as:
 *
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *  Note: Each word is guaranteed not to exceed L in length.
 */
public class JustifiedText {

    private static String justifyLine(ArrayList<String> words, int B,
                                      int lineLength, boolean lastLine) {
        StringBuilder result = new StringBuilder();
        int currentWord = 0;

        while(lineLength<B && words.size()>1 && !lastLine) {
            words.set(currentWord, words.get(currentWord)+" ");
            currentWord = (currentWord+1) % (words.size()-1);
            lineLength++;
        }
        while(words.size()>1) {
            result.append(words.remove(0));
            if(lastLine) {
                result.append(" ");
                lineLength++;
            }
        }
        result.append(words.remove(0));
        while(lineLength<B) {
            result.append(" ");
            lineLength++;
        }

        return result.toString();
    }

    public static ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        ArrayList<String> currentLine = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        while(!A.isEmpty()) {
            int currentLineLength = 0;
            while(!A.isEmpty() && currentLineLength+A.get(0).length()+currentLine.size()<=B) {
                String nextWord = A.remove(0);
                currentLine.add(nextWord);
                currentLineLength += nextWord.length();
            }
            result.add(justifyLine(currentLine, B, currentLineLength,
                    A.isEmpty()));
            currentLine.clear();
        }

        return result;
    }

    public static void main(String[] args) {
//        ArrayList<String> words1 = new ArrayList<>(Arrays.asList("This", "is"
//                , "an", "example", "of", "text", "justification."));
//        System.out.println(fullJustify(words1, 16));
        ArrayList<String> words2 = new ArrayList<>(Arrays.asList("am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui", "tnzegzuzn", "kuiwdc", "fofjkkkm", "ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv", "uurcazjc", "earsrvrq", "qlq", "lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy"));
        ArrayList<String> result2 = fullJustify(words2, 14);
        for(String line : result2) {
            System.out.println(line);
        }
    }
}

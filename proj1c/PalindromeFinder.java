/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words.txt");

        OffByOne offOne = new OffByOne();
/*
        String word = "absenteeship";
        if (word.length() >= minLength && Palindrome.isPalindrome(word,offOne)) {
            System.out.println(word);
        }
        */

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word,offOne)) {
                System.out.println(word);
            }
        }
    }

} 

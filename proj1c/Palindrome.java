/**
 * Created by acer on 2016/7/15.
 */
public class Palindrome {
    public static LinkedListDequeSolution<Character> wordToDeque(String word){
        LinkedListDequeSolution<Character> wordDeque = new LinkedListDequeSolution<Character>();
        for(int i = 0;i<word.length();i++){
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    public static boolean isPalindrome(String word){
        if(word.length() ==0 || word.length() ==1){
            return true;
        }
        if(word.charAt(0) == word.charAt(word.length() - 1)) {
            word = word.substring(1, word.length() - 1);
            return isPalindrome(word);
        }
        else
            return false;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length() ==0 || word.length() ==1){
            return true;
        }
        if(cc.equalChars(word.charAt(0) , word.charAt(word.length() - 1))) {
            word = word.substring(1, word.length() - 1);
            return isPalindrome(word,cc);
        }
        else
            return false;

    }


}

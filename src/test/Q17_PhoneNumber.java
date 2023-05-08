package test;

import java.util.*;
public class Q17_PhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()){
            return new LinkedList<String>();
        }
        List<String> result = new LinkedList<String>();
        findLetter(digits, 0, new StringBuilder(), result);

        return result;


    }

    //23

    private static final String[] dict = {"",    "",    "abc",  "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public void findLetter(String digits, int i, StringBuilder sb ,List<String> result){
        if(i == digits.length()){
            result.add(sb.toString());
            return;
        }

        for(char c : dict[digits.charAt(i) - '0'].toCharArray()){
            sb.append(c);
            findLetter(digits, i+1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args){
        Q17_PhoneNumber c = new Q17_PhoneNumber();
        System.out.println(c.letterCombinations("23"));
    }

}

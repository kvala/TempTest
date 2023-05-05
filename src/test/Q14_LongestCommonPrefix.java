package test;

public class Q14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0 ){
            return "";
        }
        
        StringBuilder res = new StringBuilder();

        for(int i = 0; i< strs[0].length();i++){
            for(String s : strs){
                if(i == s.length() || s.charAt(i) != strs[0].charAt(i)){
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        
        }

        return res.toString();
        
    }

    public static void main(String[] args){
        Q14_LongestCommonPrefix c = new Q14_LongestCommonPrefix();
        String[] input = {"flower", "flow"};
        System.out.println(c.longestCommonPrefix(input));
    }
}

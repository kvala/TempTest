public class Q14_LongestPrefix {

    /*
     * Time complexity : O(S) , where S is the sum of all characters in all strings.
     * In the worst case all n strings are the same. The algorithm compares the string S1 with the other strings. There are S character comparisons, where S is the sum of all characters in the input array.
     * Space complexity : O(1). We only used constant extra space.
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 ){
            return "";
        }

        String prefix = strs[0];

        for(int i = 1; i <  strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0 ){
                prefix = prefix.substring(0, prefix.length() - 1);
            }

            if(prefix.isEmpty()){
                return "";
            }
        }

        return prefix;
        
    }

    /*
     * n the worst case we have n equal strings with length m
     * Time complexity : O(S⋅logm), where S is the sum of all characters in all strings.
     * The algorithm makes logm iterations, for each of them there are S=m⋅n comparisons, which gives in total O(S⋅logm) time complexity.
     * Space complexity : O(1). We only used constant extra space.
     * 
     */

    public String longestCommonPrefixUsingBST(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) low = middle + 1;
            else high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) if (
            !strs[i].startsWith(str1)
        ) return false;
        return true;
    }

    public static void main(String[] args){
        Q14_LongestPrefix s = new Q14_LongestPrefix();
        String[] input = {"ketan", "ket", "ke"};
        System.out.println(s.longestCommonPrefixUsingBST(input));
    }
}

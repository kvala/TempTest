public class Q1047_RemoveAllAdjDuplicates {
     public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for(char c : s.toCharArray() ){
            
            if(cnt != 0 && sb.charAt(cnt - 1) == c){
                sb.deleteCharAt(cnt - 1);
                cnt--;
            }
            else {
                cnt++;
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Q1047_RemoveAllAdjDuplicates s = new Q1047_RemoveAllAdjDuplicates();
        System.out.println(s.removeDuplicates("abbaca"));
    }
}

// Complexity Analysis

// Time complexity : O(N), where N is a string length.
// Space complexity : O(N−D) where D is a total length
// for all duplicates.

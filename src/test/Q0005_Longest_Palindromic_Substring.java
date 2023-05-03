package test;

public class Q0005_Longest_Palindromic_Substring {
    public String longestPalindrome2(String s) {
        final String t = join('@' + s + '$', '#');
        final int n = t.length();
        // t[i - maxExtends[i]..i) ==
        // t[i + 1..i + maxExtends[i]]
        int[] maxExtends = new int[n];
        int center = 0;
    
        for (int i = 1; i < n - 1; ++i) {
          final int rightBoundary = center + maxExtends[center];
          final int mirrorIndex = center - (i - center);
          maxExtends[i] =
              rightBoundary > i && Math.min(rightBoundary - i, maxExtends[mirrorIndex]) > 0 ? 1 : 0;
    
          // Attempt to expand palindrome centered at i
          while (t.charAt(i + 1 + maxExtends[i]) == t.charAt(i - 1 - maxExtends[i]))
            ++maxExtends[i];
    
          // If palindrome centered at i expand past rightBoundary,
          // adjust center based on expanded palindrome.
          if (i + maxExtends[i] > rightBoundary)
            center = i;
        }
    
        // Find the maxExtend and bestCenter
        int maxExtend = 0;
        int bestCenter = -1;
    
        for (int i = 0; i < n; ++i)
          if (maxExtends[i] > maxExtend) {
            maxExtend = maxExtends[i];
            bestCenter = i;
          }
    
        return s.substring((bestCenter - maxExtend) / 2, (bestCenter + maxExtend) / 2);
      }
    
      private String join(final String s, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
          sb.append(s.charAt(i));
          if (i != s.length() - 1)
            sb.append(c);
        }
        return sb.toString();
      }
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();

        int lo = 0, result = 0;
        for (int i = 0; i < ch.length; i++) {
            int x = i, y = i + 1, palindrome = 0;
            while (x >= 0 && y < ch.length && ch[x] == ch[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            if (palindrome > result) {
                result = palindrome;
                lo = x;
            }

            x = i - 1;
            y = i + 1;
            palindrome = 1;
            while (x >= 0 && y < ch.length && ch[x] == ch[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            if (palindrome > result) {
                result = palindrome;
                lo = x;
            }
        }
        return s.substring(lo + 1, lo + result + 1);

    }

    public static void main(String[] args){
        Q0005_Longest_Palindromic_Substring c = new Q0005_Longest_Palindromic_Substring();

        System.out.print(c.longestPalindrome2("abba"));
    }


}

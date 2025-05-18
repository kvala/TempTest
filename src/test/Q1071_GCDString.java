public class Q1071_GCDString {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdShorter = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdShorter);
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }

    }

    public static void main(String[] args) {
        Q1071_GCDString s = new Q1071_GCDString();
        System.out.println(s.gcdOfStrings("ABCABCABCABCABC", "ABCABCABCABCABCABCABC"));
    }
}

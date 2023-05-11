package test;

public class Q28_needle {
    public int strStr(String haystack, String needle) {

        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        int h = 0, n = 0, he = haystack.length(), ne = needle.length();

        while (h < he && n < ne) {
            if (needle.charAt(n) == haystack.charAt(h)) {
                h++;
                n++;
                if (n == ne) {
                    return h - ne;
                }
            } else {
                h = h - n + 1;
                n = 0;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Q28_needle c = new Q28_needle();

        System.out.println(c.strStr("saadbutsad", "sad"));
    }
}

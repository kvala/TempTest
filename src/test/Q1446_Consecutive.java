public class Q1446_Consecutive {
    public int maxPower(String s) {
        int count = 0;
        int max = 0;
        char pre = ' ';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pre) {
                count++;
            } else {
                count = 1;
                pre = c;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Q1446_Consecutive s = new Q1446_Consecutive();
        System.out.println(s.maxPower("aabbbbeeeeee"));
    }
}

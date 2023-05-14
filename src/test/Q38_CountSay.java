package test;

public class Q38_CountSay {
    public String countAndSay(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            // Append the last one which fell off the for loop
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));

            result = sb.toString();
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Q38_CountSay c = new Q38_CountSay();
        System.out.println(c.countAndSay(4));
    }
}

import java.util.*;

public class Q2094_Find3digitEven {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> result = new ArrayList<>();

        int[] digitCounts = new int[10];

        // Count the frequency of each digit.
        for (int digit : digits) {
            digitCounts[digit]++;
        }

        for (int i = 1; i <= 9; i++) {

            if (digitCounts[i] == 0)
                continue;

            digitCounts[i]--;

            for (int j = 0; j <= 9; j++) {
                if (digitCounts[j] == 0)
                    continue;

                digitCounts[j]--;

                for (int k = 0; k <= 8; k = k + 2) {

                    if (digitCounts[k] == 0)
                        continue;

                    digitCounts[k]--;

                    int num = (100 * i) + (10 * j) + k;

                    result.add(num);

                    digitCounts[k]++;
                }
                digitCounts[j]++;

            }
            digitCounts[i]++;
        }

        int[] out = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            out[i] = result.get(i);
        }
        return out;

    }

    public static void main(String[] args) {
        Q2094_Find3digitEven s = new Q2094_Find3digitEven();
        int[] input = { 2, 1, 3, 0 };

        for (int i : s.findEvenNumbers(input)) {
            System.out.println(i);
        }
    }
}

// Output: [102,120,130,132,210,230,302,310,312,320]

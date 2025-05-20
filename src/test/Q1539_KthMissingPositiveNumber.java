public class Q1539_KthMissingPositiveNumber {
    public int findKthPositive1(int[] arr, int k) {
        for (int num : arr) {
            if (num <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }

    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int p = l + (r - l) / 2;

            // If number of positive integers
            // which are missing before arr[pivot]
            // is less than k -->
            // continue to search on the right.
            if (arr[p] - p - 1 < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = k + left
        return l + k;
    }

    public static void main(String[] args) {
        Q1539_KthMissingPositiveNumber s = new Q1539_KthMissingPositiveNumber();
        int[] input = { 2, 3, 4, 7, 11 };
        System.out.println(s.findKthPositive(input, 5));
    }
}

// 2, 3, 4, 7, 11
// 0, 1, 2, 3, 4
// 1, 2, 3, 4, 5
// 1, 1, 1, 3, 6

// The number of positive integers which are missing before the arr[idx] is
// equal to
// arr[idx] - idx - 1.
// arr[5] - 5 - 1

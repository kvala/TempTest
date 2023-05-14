package test;

public class Q34_RangeSearch {
    public int[] searchRange(int[] nums, int target) {
        final int l = firstGreaterEqual(nums, target);
        if (l == nums.length || nums[l] != target)
            return new int[] { -1, -1 };
        final int r = firstGreaterEqual(nums, target + 1) - 1;
        return new int[] { l, r };
    }

    // Finds the first index l s.t A[l] >= target
    // Returns A.length if can't find
    private int firstGreaterEqual(int[] A, int target) {
        int l = 0;
        int r = A.length;
        while (l < r) {
            final int m = (l + r) / 2;
            if (A[m] >= target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        Q34_RangeSearch c = new Q34_RangeSearch();
        int[] input = { 5, 7, 7, 8, 8, 10 };
        for (int o : c.searchRange(input, 6)) {
            System.out.println(o);
        }
    }
}

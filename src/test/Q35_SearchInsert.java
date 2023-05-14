package test;

public class Q35_SearchInsert {
    // Time: O(logn) Space: O(1)
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            final int m = (l + r) / 2;
            if (nums[m] >= target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        Q35_SearchInsert c = new Q35_SearchInsert();

        int[] input = { 1, 3, 5, 6 };
        System.out.println(c.searchInsert(input, 2));
    }
}

package test;

public class Q0004_Median_of_Two_Sorted_Arrays {

    /*
        1,2,5,6,9
        0,1,2,3,4

        find k=2

        
        Input: nums1 = [1,3], nums2 = [2]
        Output: 2.00000
        Explanation: merged array = [1,2,3] and median is 2.
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (findKthNumber(total / 2 + 1, nums1, nums2, 0, 0) +
                    findKthNumber(total / 2, nums1, nums2, 0, 0)) / 2.0;
        } else {
            return findKthNumber(total / 2 + 1, nums1, nums2, 0, 0);
        }
    }

    public int findKthNumber(int k, int[] nums1, int[] nums2, int start1, int start2) {
        if (start1 >= nums1.length)
            return nums2[start2 + k - 1];

        if (start2 >= nums2.length)
            return nums1[start1 + k - 1];

        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int m1 = start1 + k / 2 - 1;
        int m2 = start2 + k / 2 - 1;

        int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findKthNumber(k - k / 2, nums1, nums2, m1 + 1, start2);
        } else {
            return findKthNumber(k - k / 2, nums1, nums2, start1, m2 + 1);
        }
    }

    public static void main(String[] args){
        Q0004_Median_of_Two_Sorted_Arrays c = new Q0004_Median_of_Two_Sorted_Arrays();
        int[] a = {1, 2};
        int[] b = {3};

        System.out.print(c.findMedianSortedArrays(a,b));
    }
}

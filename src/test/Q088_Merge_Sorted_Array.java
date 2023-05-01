package test;

public class Q088_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currentIndex = m + n - 1,
                index1 = m - 1,
                index2 = n - 1;

        while (index1 >= 0 || index2 >= 0) {
            int first = Integer.MIN_VALUE,
                    second = Integer.MIN_VALUE;

            if (index1 >= 0) {
                first = nums1[index1];
            }
            if (index2 >= 0) {
                second = nums2[index2];
            }

            if (first > second) {
                nums1[currentIndex] = first;
                index1--;
            } else {
                nums1[currentIndex] = second;
                index2--;
            }
            currentIndex--;
        }
    }

    public static void main(String[] args) {
        Q088_Merge_Sorted_Array sol = new Q088_Merge_Sorted_Array();
        int[] num1 = {1, 2, 3, 0, 0, 0}; //m = 3
        int[] num2 = {2, 5 ,6}; //n = 3

        sol.merge(num1, 3, num2, 3);

        for (int i : num1) {
            System.out.print(i + ", ");
        }
    }    
}

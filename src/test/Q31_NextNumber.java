package test;

public class Q31_NextNumber {
    public void nextPermutation(int[] nums) {
        //n=5
        final int n = nums.length;

        // From back to front, find the first num < nums[i + 1]
        //12354 
        //i = 5-2 = 3 for 1st loop
        int i;
        for (i = n - 2; i >= 0; --i)
            if (nums[i] < nums[i + 1])
                break;

        //i = 2
        // From back to front, find the first num > nums[i], swap it with nums[i]
        if (i >= 0)
            for (int j = n - 1; j > i; --j)
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
        //12453
        // Reverse nums[i + 1..n - 1]
        reverse(nums, i + 1, n - 1);

        //result after revrese 12435
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r)
            swap(nums, l++, r--);
    }

    private void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] nums){
        Q31_NextNumber c = new Q31_NextNumber();
        int[] input = {1, 2, 3, 5, 4};
        c.nextPermutation(input);

        for(int v  : input){
            System.out.print(v);
        }
    }
}

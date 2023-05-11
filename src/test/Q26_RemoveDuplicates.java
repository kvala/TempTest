package test;

public class Q26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        //Note: We are not removing last int values. 
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                c++;
                nums[c] = nums[i];
            }

        }

        // for(int i : nums){
        //     System.out.println(i);
        // }

        return c + 1;
    }


    public static void main(String[] args){
        int[] input = {1,1,2};

        Q26_RemoveDuplicates c = new Q26_RemoveDuplicates();
        System.out.println(c.removeDuplicates(input));

        // for(int i : input){
        //     System.out.println(i);
        // }
            
    }
}

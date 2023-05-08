package test;

import java.util.*;


public class Q15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        
       
        for(int i = 0; i < nums.length;i++){
            
            //duplicate for 3 sums
            if(i> 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length - 1;

            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    List<Integer> ls = new LinkedList<Integer>();
                    ls.add(nums[i]);
                    ls.add(nums[l]);
                    ls.add(nums[r]);
                    res.add(ls);
                    l++;

                    //Duplicate for 2 sums.
                    while(nums[l] == nums[l-1] && l<r){
                        l++;
                    }
                }

                else if (sum > 0){
                    r--;
                }
                else {
                    l++;
                }
            }
        }

        return res;
    }

    public static void main (String[] args){
        Q15_ThreeSum c = new Q15_ThreeSum();
        //int[] input = {-1,0,1,2,-1,-4};
        int[] input = {2,2,2};
        for (List<Integer> out : c.threeSum(input)){
            System.out.println(out);
        }
    }
}

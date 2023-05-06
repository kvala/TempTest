package test;

import java.util.*;

public class Q16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length;i++){
            if(i> 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length - 1;

            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target){
                    return sum;
                }
                else if( Math.abs(sum - target) < Math.abs(ans-target) ){
                    ans = sum;
                }
                else if (sum > target){
                    r--;
                }
                else {
                    l++;
                }
            }
        }

        return ans;
    }
}

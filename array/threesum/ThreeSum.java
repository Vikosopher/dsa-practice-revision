package array.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // time complexity : O(n^2), The array is iterated once, and for each element, the two-pointer technique is applied takes linear time.
    // space complexity : O(1), no extra space is used, not counting the space required for the output list.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right =  nums.length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left+1]) left++;
                    left++;

                    while(left < right && nums[right] == nums[right-1]) right--;
                    right--;

                } else if(sum < 0) left++;
                else right --;
            }
        }

        return lists;
    
    }
}

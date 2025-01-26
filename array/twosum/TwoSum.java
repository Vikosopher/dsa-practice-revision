package array.twosum;

import java.util.HashMap;

public class TwoSum {

    // Approach 1 : Using two loops
    // time complexity : O(n^2), inner loop runs O(n) for each of the O(n) iterations of outer loop.
    // space complexity : O(1), additional space (ans[]) does not depend on the input size and is constant.
    public int[] twoSum1(int[] nums, int target) {
        int size = nums.length;
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        for(int i = 0; i < size - 1; i++){
            for(int j = i + 1; j < size; j++){
                if(nums[i] + nums[j] == target) {
                    ans[0] = i; 
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }


    // Approach 2 : Using Map data
    // time complexity : O(n), loop runs n times and searching in HashMap generally takes O(1).
    // space complexity : O(n), as we use the map data structure depends upon the size of nums.
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];

            if(map.containsKey(rem)){
                ans[0] = map.get(rem);
                ans[1] = i;
                return ans;
            }

            map.put(nums[i], i);  

        }
        return ans;        
    }
}
package array.containsduplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // time complexities : O(n), loop runs for n times and checking & adding in set takes constant time on average.
    // space complexities : O(n), using set data strucuture for storing elements
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){

            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false; 
        
    }


    // time complexities : O(n log n) + O(n), sorting the array then loop iteration
    // spcae complexities : O(n), Arrays.sort() method uses O(n) additional space for the sort operation
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false; 

    }
}

package array.maxsubarray;

public class MaximumSubarray {

    // Approach 1
    // time complexity : O(n), as the loop iterates through each element of the array exactly once.
    // space complexity : O(1), as no extra space is used apart from a few variables.
    public int maxSubArray1(int[] nums) {
        int currSum = 0;
        int maxSubarraySum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            maxSubarraySum = Math.max(currSum, maxSubarraySum);

            if(currSum < 0) currSum = 0;
        }
        
        return maxSubarraySum;
    }


    // Approach 2
    // time complexity : O(n logn), each recursion step halving the array + O(n), merging takes linear time => overall  O(n logn). 
    // space complexity : O(log n), recursion stack requires O(log n) for the depth of the recursion tree.
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int start, int end) {
        // base case : when single element exists return it
        if(start == end) return nums[start];

        int mid = (start + end) >> 1;
        
        // Recursively find the maximum subarray sum for the left and right halves
        int leftMax = maxSubArrayHelper(nums, start, mid);
        int rightMax = maxSubArrayHelper(nums, mid + 1, end);
        
        // Find the maximum subarray sum that crosses the midpoint
        int crossMax = maxCrossingMid(nums, start, mid, end);

        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }

    private int maxCrossingMid(int[] nums, int s, int mid, int e) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i >= s; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for(int i = mid + 1; i <= e; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

}

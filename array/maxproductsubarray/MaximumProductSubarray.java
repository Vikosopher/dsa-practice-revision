package array.maxproductsubarray;

public class MaximumProductSubarray {

    // time complexity : O(n), loop iterates through array only once.
    // space complexity : O(1), no extra space is used apart from few variables.
    public int maxProduct(int[] nums) {
        int minProd = nums[0]; 
        int maxProd = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);

            result = Math.max(result, maxProd);
        }

        return result; 
        
    }
}

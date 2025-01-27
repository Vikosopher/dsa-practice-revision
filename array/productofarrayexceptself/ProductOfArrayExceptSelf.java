package array.productofarrayexceptself;

public class ProductOfArrayExceptSelf {

    // time complexity : O(n) + O(n) => O(n), Two passes through the array, each taking O(n) time.
    // spcae complexity : O(1), Only a few additional variables are used, and the output array is not considered extra space. 
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        
        // calculate prefix product
        for(int i = 1; i < n; i++){
            result[i] = nums[i - 1] * result[i - 1];
        }

        // calculate suffix product and combine
        int suffixProduct = 1;
        for(int i = n - 1; i >= 0; i--){
            result[i] = result[i] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
        
    }
}

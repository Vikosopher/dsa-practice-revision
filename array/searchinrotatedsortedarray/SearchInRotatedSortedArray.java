package array.searchinrotatedsortedarray;

public class SearchInRotatedSortedArray {

    // time complexity : O(log n), in each iteration binary search reduces array to halves leads to logarithmic time.
    // space complexity : O(1), no extra space is used apart from few variables.
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) return mid;

            // check which part is sorted and search accordingly
            else if(nums[start] <= nums[mid]) {
                if(nums[start] <= target && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if(nums[mid] < target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }

        return -1;  
    }
}

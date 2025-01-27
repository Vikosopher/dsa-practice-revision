package array.findmininrotatedsortedarray;

public class FindMinInRotatedSortedArray {

    // time complexity : O(log n), in each iteration binary search reduces array to halves leads to logarithmic time.
    // space complexity : O(1), no extra space is used apart from few variables.
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        while(start < end) {
            int mid = (start + end) / 2;

            if(nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }

        return nums[start];
    }
}

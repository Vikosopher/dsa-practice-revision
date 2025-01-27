package array.containerwithmostwater;

public class ContainerWithMostWater {

    // time complexity : O(n), loop iterates through array only once.
    // space complexity : O(1), no extra space is used apart from few vaiables.
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            int currArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(currArea, maxArea);

            if(height[left] <= height[right]){
                int temp = height[left];
                while(left < right && height[left] <= temp) left++;
            } else {
                int temp = height[right];
                while(left < right && height[right] <= temp) right--;
            }
        }

        return maxArea;
 
    }
}

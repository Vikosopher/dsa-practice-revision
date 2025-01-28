package matrix.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // time complexity : O(m * n), triverse through matrix, total number of operations is proportional to the number of elements in the matrix (m * n).
    // spcae complexity : O(m * n), using list data structure to contain all the elements of the matrix.
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0, bottom = row - 1;
        int left = 0, right = col - 1;

        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            bottom--;

            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
        }

        return list;
        
    }
}

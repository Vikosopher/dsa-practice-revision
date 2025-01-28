package matrix.rotateimage;

public class RotateImage {

    // time complexity : O(n^2), Both the transposition and reversing steps traverse through each element of matrix only once.
    // space complexity : O(1), Only used constant amount of extra space.
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // transpose the matrix : convert rows to columns
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse each row
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;

            }
        }
        
    }
}

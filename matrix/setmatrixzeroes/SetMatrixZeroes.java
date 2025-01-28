package matrix.setmatrixzeroes;

public class SetMatrixZeroes {

    // time complexity : O(m * n), traverses the entire matrix twice, resulting in linear time complexity with respect to the number of elements in the matrix.
    // space complexity : O(1), no extra space is used apart from constant space taken by few variables.
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean firstRow = false;
        boolean firstCol = false;
        
        // search in matrix wherever found 0, set the marker to its first row and first col equals 0; 
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) firstRow = true;
                    if(j == 0) firstCol = true;

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set zeroes in the matrix according to the marker
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set zeroes in first - row, col if needed
        if(firstRow) {
            for(int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }

        if(firstCol) {
            for(int j = 0; j < row; j++) {
                matrix[j][0] = 0;
            }
        }

    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       int rowBegin = 0 , rowEnd = matrix.length - 1 , colBegin = 0, colEnd = matrix[0].length - 1;

       List<Integer> result = new ArrayList<>();

       while(rowBegin <= rowEnd && colBegin <= colEnd){
        // right
        for(int j = colBegin; j<=colEnd; j++){
            result.add(matrix[rowBegin][j]);

        }
        rowBegin++;

        //down
        for(int i = rowBegin; i<= rowEnd; i++){
            result.add(matrix[i][colEnd]);
        }
        colEnd--;

        //left
        if(rowBegin <= rowEnd){
            for(int j = colEnd; j>= colBegin; j--){
                result.add(matrix[rowEnd][j]);
            }
            rowEnd--;
        }

        //up
        if(colBegin <= colEnd){
            for(int i = rowEnd; i >= rowBegin; i--){
                result.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
       }
       return result;
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{5,3},{4,0},{2,1}};
        System.out.println( minCostRecursion(matrix) );
    }

    public static int minCostRecursion(int[][] matrix)
    {
        int[][] costMatrix = new int[matrix.length][matrix[0].length];
        int row = matrix.length;
        int col = matrix[0].length;
        int cost = 0;
        for(int i = 0 ; i < col; i ++){
            costMatrix[0][i] = cost + matrix[0][i];
            cost =  costMatrix[0][i];
        }
        cost =0;
        for(int i = 0 ; i < row; i ++){
            costMatrix[i][0] = cost + matrix[i][0];
            cost =  costMatrix[i][0];
        }

        for(int i = 1; i < row; i ++){
            for(int j = 1; j < col; j ++){
                costMatrix[i][j] = matrix[i][j] + Math.min(costMatrix[i-1][j], costMatrix[i][j-1]);
            }
        }
        return costMatrix[row-1][col-1];
    }

}
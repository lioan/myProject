package cn.com.lioan.math3;

import org.apache.commons.math3.linear.*;

public class Matrix {

    //double[]转换为矩阵
    static double[][] mdata = {{1d, 2d}, {3d, 4d}};
    static RealMatrix matrix = new Array2DRowRealMatrix(mdata);

    public static void main(String[] args) {
        System.out.println(matrix);
        System.out.println(inverseMatrix(matrix));//矩阵求逆
        System.out.println(matrix.multiply(inverseMatrix(matrix)));//矩阵相乘

        RealMatrix b = new Array2DRowRealMatrix(new double[][]{{5d, 6d, 7d}, {8d, 9d, 10d}, {11d, 12d, 13d}});//按列合并 b的行一定大于等于a的行
        System.out.println(b);
        System.out.println(combinedCol(matrix, b));

        b = new Array2DRowRealMatrix(new double[][]{{5d, 6d, 7d}});//按行合并 b的列一定要大于等于a的行
        System.out.println(b);
        System.out.println(combinedRow(matrix, b));
    }

    //矩阵求逆
    public static RealMatrix inverseMatrix(RealMatrix matrix) {
        LUDecomposition lude = new LUDecomposition(matrix);
        DecompositionSolver solver = lude.getSolver();
        RealMatrix inverseMatrx = solver.getInverse();
        return inverseMatrx;
    }

    //按列合并矩阵[a|b]
    public static RealMatrix combinedCol(RealMatrix a, RealMatrix b) {
        int col = a.getColumnDimension() + b.getColumnDimension();
        int row = a.getRowDimension();
        RealMatrix r = MatrixUtils.createRealMatrix(row, col);
        int temp = a.getColumnDimension();
        for (int i = 0; i < col; i++) {
            if (i < a.getColumnDimension()) {
                for (int j = 0; j < row; j++) {
                    r.setEntry(j, i, a.getEntry(j, i));
                }
            } else {
                for (int j = 0; j < row; j++) {
                    r.setEntry(j, i, b.getEntry(j, i - temp));
                }
            }
        }
        return r;
    }

    //按行合并矩阵[a,b]
    public static RealMatrix combinedRow(RealMatrix a, RealMatrix b) {
        int col = a.getColumnDimension();
        int row = a.getRowDimension() + b.getRowDimension();
        int temp = a.getRowDimension();
        RealMatrix result = MatrixUtils.createRealMatrix(row, col);
        for (int i = 0; i < row; i++) {
            if (i < a.getRowDimension()) {
                for (int j = 0; j < col; j++) {
                    result.setEntry(i, j, a.getEntry(i, j));
                }
            } else {
                for (int j = 0; j < col; j++) {
                    result.setEntry(i, j, b.getEntry(i - temp, j));
                }
            }
        }
        return result;
    }

    //返回各列平均值

}

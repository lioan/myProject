package cn.com.lioan.math3;

import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.stat.descriptive.moment.*;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;

import java.util.Arrays;

public class Math3Usage {
    public static void main(String[] args) {
//        matrixCal();
//        basicCal();

        double[][] data = {{1d, 2d}, {3d, 4d}};
        System.out.println(getDet(data));
        System.out.println(MatrixUtils.createRealMatrix(data));
        System.out.println(getMatrDet(MatrixUtils.createRealMatrix(data)));
    }

    public static void basicCal() {
        double[] values = new double[]{0.33, 1.33, 0.27333, 0.3, 0.501, 0.444, 0.44, 0.34496, 0.33, 0.3, 0.292, 0.667};
        values = new double[]{1.0, 2.0, 3.0};

        //min max sum忽略
        Mean mean = new Mean(); //算术平均
        Product product = new Product(); //乘积
        Variance variance = new Variance(); //方差 默认自由度为n-1 即isBiasCorrected=ture
        System.out.println("variance.isBiasCorrected() default value:" + variance.isBiasCorrected());
//        variance.setBiasCorrected(false);
//        System.out.println("variance.isBiasCorrected() vaule:" + variance.isBiasCorrected());

        System.out.println("mean:" + mean.evaluate(values));
        System.out.println("product:" + product.evaluate(values));
        System.out.println("variance:" + variance.evaluate(values));

        System.out.println("------------------Statistics-------------------------");

        Percentile percentile = new Percentile(); //百分位数
        GeometricMean geoMean = new GeometricMean(); //几何平均数
        Skewness skewness = new Skewness(); //??
        Kurtosis kurtosis = new Kurtosis(); //峰度??
        SumOfSquares sumOfSquares = new SumOfSquares(); //平方和 SumOfLogs SumOfClusterVariances
        StandardDeviation standardDeviation = new StandardDeviation(); //标准差
        System.out.println("percentile:" + percentile.evaluate(values, 80.0));
        System.out.println("geoMean:" + geoMean.evaluate(values));
        System.out.println("skewness:" + skewness.evaluate(values));
        System.out.println("kurtosis:" + kurtosis.evaluate(values));
        System.out.println("sumOfSquares:" + sumOfSquares.evaluate(values));
        System.out.println("standardDeviation:" + standardDeviation.evaluate(values));

        System.out.println("-------------------------Matrix------------------------------");

        //Create a real matrix with two rows and three columns
        double[][] matrixData = {{1d, 2d, 3d}, {2d, 5d, 3d}};
        RealMatrix rm = new Array2DRowRealMatrix(matrixData);
        System.out.println(rm);

        //one more with three rows,two columns
        double[][] matrixData2 = {{1d, 2d}, {2d, 5d}, {1d, 7d}};
        RealMatrix rn = new Array2DRowRealMatrix(matrixData2);

        //转换为数组
        System.out.println("rn :" + rn);
        System.out.println("rn data[1][1]:" + rn.getData()[1][1]);

        RealMatrix rp = rm.multiply(rn);
        System.out.println("rp:" + rp);

        System.out.println(rp.getRowDimension());
        System.out.println(rp.getColumnDimension());

        //Invert rp, using LUDecomposition
        RealMatrix rpInverse = new LUDecomposition(rp).getSolver().getInverse();
        System.out.println("rpInverse:" + rpInverse);


    }

    public static void matrixCal() {
        //构造一个维度为7的稀疏矩阵
        OpenMapRealVector om = new OpenMapRealVector(7);
        //填充稀疏向量
        om.setEntry(2, 1.0);
        om.setEntry(4, 1.0);
        //输出稀疏向量当前的值
        System.out.println("sparse:" + Arrays.toString(om.toArray()));

        //直接以一维数组构造稠密向量
        double[] a = new double[]{0, 0.2, 0.3, 0.4, 0, 0, 0};
    }

    public static RealMatrix createMatrix(int row, int col) {
        RealMatrix matrix = MatrixUtils.createRealMatrix(row, col);

        return matrix;
    }

    //计算n阶矩阵的行列式值
    public static double getMatrDet(RealMatrix matrix) {
        return getDet(matrix.getData());
    }

    //计算n阶行列式值
    public static double getDet(double[][] det) {
        double r = 0.0d;
        if (det.length == 1) {
            return det[0][0];
        } else {
            for (int i = 0; i < det.length; i++) {
                r += det[0][i] * Math.pow(-1, i) * getDet(M(det, 1, i + 1));//按行列式det的第一行展开计算
//                r += det[i][0] * Math.pow(-1, i) * getDet(M(det, i+1, 1));//按行列式det的第一列展开计算
            }
        }
        return r;
    }

    //计算行列式a的余子式M
    private static double[][] M(double[][] a, int row, int col) {
        double[][] ans = new double[a.length - 1][a.length - 1];//a的余子式返回结果
        double[] temp = new double[(a.length - 1) * (a.length - 1)];//临时数组，顺序存储余子式的值
        int k = 0;
        //执行余子式计算：剔除a中按行列展开的元素
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == row - 1) {
                    continue;
                } else if (j == col - 1) {
                    continue;
                }
                temp[k++] = a[i][j];
            }
        }
        //生成余子式：依次从temp中取值赋值ans
        k = 0;
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = temp[k++];
            }
        }
        return ans;
    }
}

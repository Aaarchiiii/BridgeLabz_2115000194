package D_28_01_25.Level3;

import java.util.*;
public class MatrixOperations {
    public static int[][] createRandomMatrix(int rows,int cols){
        int[][] matrix=new int[rows][cols];
        Random random=new Random();
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                matrix[i][j]=random.nextInt(10);
        return matrix;
    }
    public static int[][] addMatrices(int[][] a,int[][] b){
        int rows=a.length,cols=a[0].length;
        int[][] result=new int[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                result[i][j]=a[i][j]+b[i][j];
        return result;
    }
    public static int[][] subtractMatrices(int[][] a,int[][] b){
        int rows=a.length,cols=a[0].length;
        int[][] result=new int[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                result[i][j]=a[i][j]-b[i][j];
        return result;
    }
    public static int[][] multiplyMatrices(int[][] a,int[][] b){
        int rows=a.length,cols=b[0].length,kLen=a[0].length;
        int[][] result=new int[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                for(int k=0;k<kLen;k++)
                    result[i][j]+=a[i][k]*b[k][j];
        return result;
    }
    public static int[][] transposeMatrix(int[][] matrix){
        int rows=matrix.length,cols=matrix[0].length;
        int[][] result=new int[cols][rows];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                result[j][i]=matrix[i][j];
        return result;
    }
    public static int determinant2x2(int[][] matrix){
return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
}
    public static int determinant3x3(int[][] matrix){
        return matrix[0][0]*(matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1])
        -matrix[0][1]*(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0])
        +matrix[0][2]*(matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0]);
    }
    public static double[][] inverse2x2(int[][] matrix){
        int det=determinant2x2(matrix);
        if(det==0)return null;
            double[][] result=new double[2][2];
            result[0][0]=matrix[1][1]/(double)det;
            result[0][1]=-matrix[0][1]/(double)det;
            result[1][0]=-matrix[1][0]/(double)det;
            result[1][1]=matrix[0][0]/(double)det;
    return result;
    }
    public static double[][] inverse3x3(int[][] matrix){
        int det=determinant3x3(matrix);
        if(det==0)return null;
        double[][] result=new double[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                int[][] minor=new int[2][2];
                int mi=0,mj;
                for(int x=0;x<3;x++){
                    if(x==i)continue;
                    mj=0;
                    for(int y=0;y<3;y++){
                        if(y==j)continue;
                        minor[mi][mj++]=matrix[x][y];
                    }
                    mi++;
                }
                result[j][i]=Math.pow(-1,i+j)*determinant2x2(minor)/(double)det;
            }
            return result;
    }
    public static void displayMatrix(double[][] matrix){
        for(double[] row:matrix){
            for(double value:row)
                System.out.printf("%6.2f",value);
            System.out.println();
        }
    }
    public static void displayMatrix(int[][] matrix){
        for(int[] row:matrix){
            for(int value:row)
                System.out.printf("%6d",value);
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] matrixA=createRandomMatrix(3,3);
        int[][] matrixB=createRandomMatrix(3,3);
        System.out.println("Matrix A:");
        displayMatrix(matrixA);
        System.out.println("Matrix B:");
        displayMatrix(matrixB);
        System.out.println("Addition:");
        displayMatrix(addMatrices(matrixA,matrixB));
        System.out.println("Subtraction:");
        displayMatrix(subtractMatrices(matrixA,matrixB));
        System.out.println("Multiplication:");
        displayMatrix(multiplyMatrices(matrixA,matrixB));
        System.out.println("Transpose of A:");
        displayMatrix(transposeMatrix(matrixA));
        System.out.println("Determinant of A:"+determinant3x3(matrixA));
        System.out.println("Inverse of A:");
        displayMatrix(inverse3x3(matrixA));
    }
}

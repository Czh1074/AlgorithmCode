package com.example.algorithmcode.hot100;

/**
 * 旋转图像
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/5 23:17
 **/
public class problem_48 {

    public static void rotate(int[][] matrix) {
        // 先转置
        for (int i = 0; i <= matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 行逆转
        for(int i = 0; i < matrix.length; i++){
            int m = 0, n = matrix.length - 1;
            while(m < n){
                int temp = matrix[i][m];
                matrix[i][m] = matrix[i][n];
                matrix[i][n] = temp;
                m++;
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] x = new int[3][3];
        x[0][0] = 1;
        x[0][1] = 2;
        x[0][2] = 3;
        x[1][0] = 4;
        x[1][1] = 5;
        x[1][2] = 6;
        x[2][0] = 7;
        x[2][1] = 8;
        x[2][2] = 9;

        rotate(x);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
}

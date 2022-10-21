package _10_행렬의_덧셈;

import java.util.Arrays;

public class testDimensionalArray {
    public static void main(String[] args) {
        // 행렬의 덧셈
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};
        int[][] answer = new int [arr1.length][arr1[0].length];

        for (int i=0; i<arr1.length;i++){
            for (int j=0; j<arr1[0].length;j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        System.out.println(Arrays.deepToString(answer));
    }
}

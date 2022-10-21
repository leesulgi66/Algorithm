package _29_배열두개_더하기;

import java.util.Arrays;

public class testQuiz01 {
    public static void main(String[] args) {
        int[][] arr1 = {{5,7,1},{2,3,5}}; //배열 1과
        int[][] arr2 = {{5,1,6},{7,5,6}}; //배열 2의 각 각 숫자를 더하라
        boolean[][] signs={{true,true,false},{false,true,false}}; //단 true일 시 양수 false 일 시 음수이다.
        int[][] arr3 = new int[arr1.length][arr1[0].length];

        for (int i=0; i<arr1.length;i++){
            for(int j=0; j<arr1[i].length; j++){
                if (signs[i][j] == true){
                    arr3[i][j] = arr1[i][j] + arr2[i][j];
                }else{
                    arr3[i][j] = - arr1[i][j] - arr2[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(arr3));
    }
}

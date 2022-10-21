package _14_나누어_떨어지는_숫자와_배열;

import java.util.Arrays;

public class testDivisonAndArray {
    public static void main(String[] args) {
        int[] arr = {5,9,7,10};
        int divisor = 5;
        // 나누어 떨어지는 숫자와 배열
        int[] newarr = new int[arr.length];
        int cnt = 0;

        Arrays.sort(arr);
        for (int i=0; i<arr.length;i++){
            if (arr[i]/divisor>0 && arr[i]%divisor == 0){
                newarr[i] = arr[i];
                cnt ++;
            }
        }
        int[] answer = new int[cnt];
        int setcnt = 0;
        for (int j=0; j<arr.length;j++){
            if (newarr[j]>0){
                answer[setcnt]= newarr[j];
                setcnt ++;
            }
        }
        if (answer.length > 0){
            System.out.println(Arrays.toString(answer));
        }else {
            answer = new int[]{-1};
        }
    }
}

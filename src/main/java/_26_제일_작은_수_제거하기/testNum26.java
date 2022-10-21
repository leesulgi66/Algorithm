package _26_제일_작은_수_제거하기;


import java.util.Arrays;

public class testNum26 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,6};
        // 제일 작은 수 제거하기
        int firstnum = arr[0];
        for(int i=0; i<arr.length;i++){
            if(firstnum > arr[i]){
                firstnum = arr[i];
            }
        }

        int[] answer = new int[arr.length-1];
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==firstnum){
                continue;
            }else {
                answer[count] = arr[i];
                count ++;

            }
        }
        if (answer.length == 0){
            int[] an1 = {-1};
            answer = an1;
            System.out.println(Arrays.toString(answer));
        }else{
            System.out.println(Arrays.toString(answer));
        }
    }
}

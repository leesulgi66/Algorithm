package _23_자연수_뒤집기;

import java.util.Arrays;

public class testNum23 {
    public static void main(String[] args) {
        long n = 12345;
        // 자연수 뒤집기
        String num = String.valueOf(n);
        String[]nums = num.split("");
        System.out.println(Arrays.toString(nums));//현재 배열 확인

        int numcnt = nums.length-1;
        String[]reversenum = new String[nums.length];
        for (int i=0;i< nums.length;i++) {
            reversenum[numcnt] = nums[i];
            numcnt --;
        }
        int[] answer = Arrays.stream(reversenum).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(answer));//뒤집어 졌는지 확인
    }

}

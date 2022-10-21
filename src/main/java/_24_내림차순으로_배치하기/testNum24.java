package _24_내림차순으로_배치하기;

import java.util.Arrays;
import java.util.Collections;

public class testNum24 {
    public static void main(String[] args) {
        long n = 118372;
        // 내림차순으로 배치하기
        String num = String.valueOf(n);
        String[] nums = num.split("");
        Arrays.sort(nums, Collections.reverseOrder());
        String strint = "";
        for(int i=0; i<nums.length;i++){
            strint += Integer.parseInt(nums[i]);
        }
        long answer = Long.parseLong(strint);
        System.out.println(answer);
    }
}

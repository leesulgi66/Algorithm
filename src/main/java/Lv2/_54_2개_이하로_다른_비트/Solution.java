package Lv2._54_2개_이하로_다른_비트;

import java.util.Arrays;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            long num = numbers[i];
            String bNum = Long.toBinaryString(numbers[i]);
            if(num%2==0) {
                answer[i] = num+1;
            }else{
                int idx = bNum.lastIndexOf("0");

                if (idx == -1) {
                    String tmp = "10" + bNum.substring(1, bNum.length());
                    answer[i] = Long.parseLong(tmp, 2);
                } else {
                    String tmp = bNum.substring(0, idx) + "10" + bNum.substring(idx + 2, bNum.length());
                    answer[i] = Long.parseLong(tmp, 2);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new long[] {2, 7})));
    }
}

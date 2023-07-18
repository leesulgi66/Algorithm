package Algorithm.탐색_종류;

import java.util.Arrays;

public class 이진탐색 {
    public static void main(String[] args) {
        int[] data = new int[] {3,7,23,15,13,35,38,41,46,77,55,67,68,72,49,86};
        boolean find = false;
        int target = 46;

        Arrays.sort(data);

        int start = 0;
        int end = data.length-1;

        while(start <= end) {
            int midIndex = (start+end)/2;
            int mid = data[midIndex];

            if(target < mid) {
                end = midIndex -1;
            }else if(target > mid) {
                start = midIndex + 1;
            }else {
                find = true;
                System.out.println("target = "+data[midIndex]);
                break;
            }
        }
        System.out.println(find);
    }
}

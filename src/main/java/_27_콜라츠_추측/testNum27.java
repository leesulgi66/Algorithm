package _27_콜라츠_추측;

public class testNum27 {
    public static void main(String[] args) {
        int num = 626331;
        // 콜라츠 추측
        long nums = Long.valueOf(num);
        int result = 0;

        while (nums > 0){
            if (nums == 1){
                break; //return;
            }else if(nums%2 ==0){
                nums = nums/2;
                result ++;
            }else if (nums%2 ==1){
                nums = nums*3 +1;
                result ++;
            }
        }

        if(result <500){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }

    }
}

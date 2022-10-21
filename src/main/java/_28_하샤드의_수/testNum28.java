package _28_하샤드의_수;

public class testNum28 {
    public static void main(String[] args) {
        int x = 12;
        // 하샤드의 수
        int y = x;
        int sumNum = 0;

        while(x > 0){
            sumNum += x%10;
            x = x/10;
        }


        if (y%sumNum == 0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}

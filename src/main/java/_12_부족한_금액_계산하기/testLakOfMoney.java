package _12_부족한_금액_계산하기;

public class testLakOfMoney {
    public static void main(String[] args) {
        // 부족한 금액 계산하기
        int price = 3;
        int money = 20;
        int count = 4;
        long totalprice = 0;

        for (int i=0; i<count; i++){
            totalprice += price*(i+1);
        }
        long answer = money-totalprice;
        if (totalprice > money) {
            System.out.println(-answer);
        }else{
            System.out.println(0);
        }
    }
}

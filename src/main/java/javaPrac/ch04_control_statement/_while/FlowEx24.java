package javaPrac.ch04_control_statement._while;

public class FlowEx24 {
    public static void main(String[] args) {
        int i = 11;

        System.out.println("카운트 다운을 시작합니다.");

        while(i--!=0){
            System.out.println(i);

            for(int j=0; j<2_000_000_000;j++) { // 빈문장. 지연 목적
                ;
            }
        }
        System.out.println("GAME OVER");
    }
}

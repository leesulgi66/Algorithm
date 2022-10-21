package _09_핸드폰_번호_가리기;

public class testNum09 {
    public static void main(String[] args) {
        String phone_number = "01033334444";
        // 핸드폰 번호 가리기
        String answer = "*".repeat(phone_number.length()-4)+ phone_number.substring(phone_number.length()-4);
        System.out.println(answer);
    }
}

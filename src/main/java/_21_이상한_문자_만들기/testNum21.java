package _21_이상한_문자_만들기;

public class testNum21 {
    public static void main(String[] args) {
        String s = "try hello world";
        // 이상한 문자 만들기
        String answer = "";
        String[] str = s.split("");

        int idex = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(" ")) {
                idex = 0;
            } else if (idex % 2 == 0) {
                str[i] = str[i].toUpperCase();
                idex++;
            } else if (idex % 2 != 0) {
                str[i] = str[i].toLowerCase();
                idex++;
            }
            answer += str[i];
        }
        System.out.println(answer);
    }
}

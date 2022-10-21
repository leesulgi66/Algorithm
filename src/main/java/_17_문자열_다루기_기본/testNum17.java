package _17_문자열_다루기_기본;

public class testNum17 {
    public static void main(String[] args) {
        String s= "a123";
        // 문자열 다루기 기본
        boolean answer = true;
        String nums = "1234567890";
        int sum = 0;

        if(s.length()==4 ||s.length()==6) {
            for (int i = 0; i < nums.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == nums.charAt(i)) {
                        sum += 1;
                    }
                }
            }
        }
        if (sum == s.length()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}

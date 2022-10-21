package _20_완주하지_못한_선수;

import java.util.Arrays;

public class testNum20 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        // 완주하지 못한 선수
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i =0;
        for (;i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                break;
            }
        }
        System.out.println(participant[i]);
    }
}

package _07_음양_더하기;

public class testNum07 {
    public static void main(String[] args) {
        //음양 더하기
        int[] absolutes ={4,7,12};
        boolean[] signs = {true, false, true};
        int answer = 0;
        for (int i=0; i<absolutes.length; i++){
            if (signs[i] == true){
                answer += absolutes[i];
            }else {
                answer -= absolutes[i];
            }
        }
        System.out.println(answer);
    }
}

package _03_가운데_글자_가져오기;

public class testStringOfCenter {

    public static void main(String[] args) {
        //가운데 글자 가져오기
        String s = "abcde";
        String answer = "";
        if (s.length()%2==0){
        answer = s.substring(s.length()/2-1,s.length()/2+1);
        }else{
        answer = s.substring(s.length()/2,s.length()/2+1);
        }
        System.out.println(answer);
    }
}

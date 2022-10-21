package _16_문자열_내_p와_p의_개수;

public class testWordsBoolean {
    public static void main(String[] args) {
        String s = "pPoooyY";
        // 문자열 내 p와 p의 개수
        String a = s.toLowerCase();
        int cnt = 0;
        for(int i=0; i<a.length();i++){
            if (a.charAt(i)=='p'){
                cnt ++;
            }else if(a.charAt(i)=='y'){
                cnt --;
            }
        }
        if (cnt == 0){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }

}

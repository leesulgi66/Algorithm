package _19_수박수박수박수박수;

public class testNum19 {
    public static void main(String[] args) {
        int n = 5;
        // 수박수박수박수박수박수
        String subak = "";
        for (int i=0; i<n; i++){
            if (i%2 ==0) {
                subak += "수";
            }else{
                subak += "박";
            }
        }
        System.out.println(subak);

    }
}

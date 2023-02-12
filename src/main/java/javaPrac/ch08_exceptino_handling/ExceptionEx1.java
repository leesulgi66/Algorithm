package javaPrac.ch08_exceptino_handling;

public class ExceptionEx1 {
    public static void main(String[] args) {
        try {
            try {   } catch (Exception e) { }
        } catch (Exception e) {
            //try {   } catch (Exception e) { }   // 에러. 변수 e 가 중복 선언 되었다.
        }

        try{

        }catch (Exception e){

        }
    }
}

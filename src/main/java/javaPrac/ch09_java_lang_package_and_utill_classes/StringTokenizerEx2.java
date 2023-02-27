package javaPrac.ch09_java_lang_package_and_utill_classes;

import java.util.*;

public class StringTokenizerEx2 {
    public static void main(String[] args) {
        String expression = "x=100*(200+300)/2";
        StringTokenizer st = new StringTokenizer(expression, "+-*/=()", true);  // "+-*/=()"전체가 하나의 구분자가 아니라 각각의 문자가 모두 구분자.
        while(st.hasMoreElements()) {
            System.out.println(st.nextToken());
        }
    }
}

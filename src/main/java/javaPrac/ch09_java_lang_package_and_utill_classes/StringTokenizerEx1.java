package javaPrac.ch09_java_lang_package_and_utill_classes;

import java.util.*;

public class StringTokenizerEx1 {
    public static void main(String[] args) {
        String source = "100,200,300,400";
        StringTokenizer st = new StringTokenizer(source, ",");

        while(st.hasMoreElements()) {
            System.out.println(st.nextToken());
        }
    }
}

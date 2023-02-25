package javaPrac.ch09_java_lang_package_and_utill_classes;

import java.util.regex.*;

public class RegularEx1 {
    public static void main(String[] args) {
        String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc"};

        // 정규식을 매개변술 Pattern클래스의 static메서드인 Pattern compile(String regex)을 호출하여 Pattern인스턴스를 얻는다.
        Pattern p = Pattern.compile("c[a-z]*"); // c로 시작하는 소문자영어

        for(int i=0; i<data.length; i++) {
            // 정규식으로 비교할 대상을 매개변수로 Pattern클래스의 Matcher matcher(CharSequence input)를 호출해서 Matcher인스턴스를 얻는다.
            Matcher m = p.matcher(data[i]);
            // Matcher인스턴스에 boolean matches()를 호출해서 정규식에 부합하는지 확인한다.
            if(m.matches())
                System.out.print(data[i] + ",");
        }
    }
}

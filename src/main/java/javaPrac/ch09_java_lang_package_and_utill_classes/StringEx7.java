package javaPrac.ch09_java_lang_package_and_utill_classes;

public class StringEx7 {
    public static void main(String[] args) {
        String fullName = "Hello.java";

        // fullName의 '.'의 위치를 찾는다.
        int index = fullName.indexOf('.');

        // fullName의 첫 글자부터 '.'까지의 문자열을 추출한다.
        String fileName = fullName.substring(0, index);
        // '.'의 다음 문자 부터 시작해서 문자열의 끝까지 추출한다.
        // fullName.substring(index+1, fullName.length()); 의 결과와 같다.
        String ext = fullName.substring(index+1);

        System.out.println(fullName + "의 확장자를 제외한 이름은 "+fileName);
        System.out.println(fullName + "의 확장자는 "+ext);
    }
}

package javaPrac.ch11_collections_framework._07_HashSet;

import java.util.*;

public class HashSetEx1 {
    public static void main(String[] args) {
        Object[] objArr = {"1", new Integer(1),"2","2","3","3","4","4","4"};
        Set set = new HashSet();

        for(int i=0; i<objArr.length; i++) {
            set.add(objArr[i]);
        }
        // HashSet에 저장된 요소들을 출력한다.
        System.out.println(set);
    }
}

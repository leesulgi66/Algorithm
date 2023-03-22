package javaPrac.ch11_collections_framework._08_TreeSet;

import java.util.*;

public class TreeSetLotto {
    public static void main(String[] args) {
        Set set = new TreeSet();

        for(int i=0; set.size()<6; i++) {
            int num = (int)(Math.random()*45)+1;
            set.add(num);
        }

        System.out.println(set);
    }
}

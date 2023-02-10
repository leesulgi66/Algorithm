package javaPrac.ch07_object_oriented_programming2._08_inner_class.anonymous_class;

import java.awt.*;
import java.awt.event.*;

public class InnerEx8 {
    public static void main(String[] args){
        Button b = new Button("Start");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent occurred!!!!");
            }
        });
    }
}

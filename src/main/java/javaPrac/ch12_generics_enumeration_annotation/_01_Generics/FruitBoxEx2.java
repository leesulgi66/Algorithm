package javaPrac.ch12_generics_enumeration_annotation._01_Generics;

import java.util.ArrayList;

class Fruit2 implements Eatable {
    public String toString() { return "Fruit"; }
}

interface Eatable {}
class Apple2 extends Fruit2 { public String toString() { return "Apple"; }}
class Grape2 extends Fruit2 { public String toString() { return "Grape"; }}
class Toy2 { public String toString() { return "Toy"; }}
public class FruitBoxEx2 {
    public static void main(String[] args) {
        FruitBox<Fruit2> fruitBox = new FruitBox<Fruit2>();
        FruitBox<Apple2> appleBox = new FruitBox<Apple2>();
        FruitBox<Grape2> grapeBox = new FruitBox<Grape2>();
//        FruitBox<Grape2> grapeBox2 = new FruitBox<Apple2>();    // 에러. 타입 불일치
//        FruitBox<Toy>    toyBox   = new FruitBox<Toy>();    // 에러.

        fruitBox.add(new Fruit2());
        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());
        appleBox.add(new Apple2());
//        appleBox.add(new Grape2()); // 에러. Grape는 Apple의 자손이 아님
        grapeBox.add(new Grape2());

        System.out.println("fruitBox-"+fruitBox);
        System.out.println("appleBox-"+appleBox);
        System.out.println("grapeBox-"+grapeBox);
    }
}

class FruitBox<T extends Fruit2 & Eatable> extends Box<T> {}

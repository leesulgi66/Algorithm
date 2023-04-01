package javaPrac.ch12_generics_enumeration_annotation._01_Generics;

import java.util.ArrayList;

class Fruit3                 { public String toString() { return "Fruit"; }}
class Apple3 extends Fruit3  { public String toString() { return "Apple"; }}
class Grape3 extends Fruit3  { public String toString() { return "Grape"; }}

class Juice3 {
    String name;

    Juice3(String name)       { this.name = name + "Juice"; }
    public String toString() { return name; }
}

class Juicer3 {
    static Juice3 makeJuice(FruitBox3<? extends Fruit3> box) {
        String tmp = "";

        for(Fruit3 f : box.getList())
            tmp += f + " ";
        return new Juice3(tmp);
    }
}

public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox3<Fruit3> fruitBox = new FruitBox3<Fruit3>();
        FruitBox3<Apple3> appleBox = new FruitBox3<Apple3>();

        fruitBox.add(new Apple3());
        fruitBox.add(new Grape3());
        appleBox.add(new Apple3());
        appleBox.add(new Apple3());

        System.out.println(Juicer3.makeJuice(fruitBox));
        System.out.println(Juicer3.makeJuice(appleBox));
    }
}

class FruitBox3 <T extends Fruit3> extends Box3<T> {}

class Box3<T>{
    ArrayList<T> list = new ArrayList<T>();
    void add(T item)    { list.add(item);}
    T get(int i)        { return list.get(i);}
    ArrayList<T> getList() { return list; }
    int size()          { return list.size();}
    public String toString() { return list.toString(); }
}

package javaPrac.ch07_object_oriented_programming2._05_polymorphism.poly_argument_test3;

import java.util.Vector;

class Product {
    int price;  // 제품의 가격
    int bonusPoint; // 제품구매시 제공하는 보너스 점수

    Product(int  price) {
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }

    Product() {
        price = 0;
        bonusPoint = 0;
    }
}

class Tv extends Product {
    Tv() { super(100); }
    public String toString() { return "Tv"; }
}

class Computer extends Product {
    Computer() { super(200); }
    public String toString() { return "Computer"; }
}

class Audio extends Product {
    Audio() { super(50); }
    public String toString() { return "Audio"; }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    Vector item = new Vector(); // 구임한 제품을 저장하는데 사용될 Vector객체

    void buy(Product p) {
        if(money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살수 없습니다.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        item.add(p);
        System.out.println(p + "을/를 구입하셨습니다.");
    }

    void refund(Product p){ // 구입한 제품을 환불한다.
        if(item.remove(p)) {    // 제품을 Vector에서 제거한다.
            money += p.price;
            bonusPoint -= p.bonusPoint;
            System.out.println(p + "을/를 반품하셨습니다.");
        } else {    // 반품에 실패하였을 경우
            System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
        }
    }

    void summary() {    // 구매한 물품에 대한 정보를 요약해서 보여준다.
        int sum = 0;    // 구입한 물품의 가격합계
        String itemList = "";   // 구입한 물품목록

        if(item.isEmpty()) {    // Vector가 비어있는지 확인한다.
            System.out.println("구입하신 제품이 없습니다.");
            return;
        }

        // 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
        for(int i=0; i<item.size(); i++) {
            Product p = (Product)item.get(i);   // Vector의 i번째에 있는 객체를 얻어온다.
            sum += p.price;
            itemList += (i==0) ? "" + p : ", "+ p;
        }
        System.out.println("구입한 물품의 총금액은 "+sum+ "만원입니다.");
        System.out.println("구입하신 제품은 "+itemList+"입니다.");
    }
}

public class PolyArgumentTest3 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        Tv tv = new Tv();
        Computer com = new Computer();
        Audio audio = new Audio();

        b.buy(tv);
        b.buy(com);
        b.buy(audio);
        b.summary();
        System.out.println();
        b.refund(com);
        b.summary();
    }
}
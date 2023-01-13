package Section1.ObjAdv.PolymorphismEx;

public class PolymorphismEx {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buyCoffee(new Americano());
        customer.buyCoffee(new CaffeLatte());
        customer.buyCoffee(new LemonAde());

        System.out.println("현재 잔액은 " + customer.money + "원 입니다.");
    }
}

class Coffee {
    int price;

    public Coffee(int price) {
        this.price = price;
    }
}

class Americano extends Coffee {
    public Americano() {
        super(4000); // 상위 클래스 Coffee의 생성자를 호출
    }

    public String toString() {return "아메리카노";} // Object클래스 toString() 메서드 오버라이딩딩
}

class CaffeLatte extends Coffee {
    public CaffeLatte() {
        super(5000);
    }

    public String toString() {return "카페라떼";}
}

// 품목 하나 추가
class LemonAde extends Coffee{
    public LemonAde(){
        super(4500);
    }

    public String toString() {return "레몬 에이드";}
}

class Customer {
    int money = 50000;

    // 하나로 압축하기.
    void buyCoffee(Coffee coffee) { // 매개변수의 다형성
        if(money < coffee.price) { // 물건 가격보다 돈이 없는 경우
            System.out.println("잔액이 부족합니다");
            return;
        }
        money = money - coffee.price;
        System.out.println(coffee + "를 구입했습니다.");
    }
}

//  두 개의 메서드를 하나의 buyCoffee메서드로 만듬
//void buyCoffee(Americano americano) { // 아메리카노 구입
//    money = money - americano.price;
//}
//
//void buyCoffee(CaffeLatte caffeLatte) { // 카페라뗴 구입
//    money = money - caffeLatte.price;
//}






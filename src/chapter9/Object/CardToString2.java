package chapter9.Object;

public class CardToString2 {
    public static void main(String[] args) {
        Card2 c1 = new Card2();
        Card2 c2 = new Card2("HEART", 10);
        System.out.println(c1.toString()); // kind='SPADE, number=1
        System.out.println(c2.toString()); // kind='HEART, number=10
        // 출력시 멤버변수내용출력으로 잘 출력되어 나옴 => but, 사실 재정의된 toString 메서드가 존재하고 있기 때문에, 출력 시 toString() 하지 않아도 자동으로 멤버변수내용값출력 으로 출력이 이뤄진다.
    }
}

class Card2 {
    String kind;
    int number;

    // 기본생성자
    Card2(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }
    Card2() {
        this("SPADE", 1);  // 기본생성자를 호출하고 있음 // 아무 인자도 투입없을시 기본적으로 SPADE 와 1 로 초기화하도록 하고 있음
    }

    @Override
    public String toString() {
        return "kind='" + kind + ", number=" + number ;
    }
}

package chapter9.Object;

public class CardToString {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        // toString() 에 대해 재정의한 적 없으면 : '클래스명+@+메모리주소해쉬코드값16진수문자열' 값만 리턴될 것
//        System.out.println(c1.toString()); //chapter9.Object.Card@1b6d3586
//        System.out.println(c2.toString()); //chapter9.Object.Card@4554617c

        // toString() 에 대해 재정의 했으면 : 재정의한 내용대로 출력
        System.out.println(c1.toString()); // Card{kind='SPADE', number=1}
        System.out.println(c2.toString()); // Card{kind='SPADE', number=1}
    }
}

class Card {
    String kind;
    int number;

    Card() {
        this("SPADE", 1);
    }

    Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Card{" +
                "kind='" + kind + '\'' +
                ", number=" + number +
                '}';
    }
}

// ToStringTest.java 파일 예제 이어서 진행
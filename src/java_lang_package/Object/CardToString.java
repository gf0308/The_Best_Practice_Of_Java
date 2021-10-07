package java_lang_package.Object;

public class CardToString {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        // toString() 에 대해 재정의한 적 없음 : 클래스명+@+메모리주소해쉬코드값16진수문자열 값만 리턴될 것
        System.out.println(c1.toString()); //java_lang_package.Object.Card@1b6d3586
        System.out.println(c2.toString()); //java_lang_package.Object.Card@4554617c
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
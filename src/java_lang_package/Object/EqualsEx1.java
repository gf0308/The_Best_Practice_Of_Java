package java_lang_package.Object;

public class EqualsEx1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        // Object클래스로부터 상속된 equals() 로 비교해보기
        if(v1.equals(v2)) {
            System.out.println("v1과 v2는 같습니다.");
        }
        else {
            System.out.println("v1과 v2는 다릅니다.");
        }

        v2 = v1;

        if(v1.equals(v2)) {
            System.out.println("v1과 v2는 같습니다.");
        }
        else {
            System.out.println("v1과 v2는 다릅니다.");
        }
    } // main
}

class Value {
    int value;

    Value(int value) {
        this.value = value;
    }
}


/*
 한 클래스파일 내에 여러 개의 class 를 정의해서 쓸 수 있다
 하지만 public이 붙을 수 있는 class 는 '해당 클래스 클래스명'으로 되어있는 클래스 뿐 이다
 그 이유는 public이 붙은 클래스는 그 클래스파일 내의 주 클래스 이기 때문이다.

 자바에는 (클래스파일 내 클래스정의문에서) "클래스명 앞에 public 접근제어자가 붙어있으면, 그 클래스명은 파일명과 동일해야 한다"는 규칙이 있다.
 이러한 규칙이 있는 이유는 : 자바에서 한 클래스파일 내에 여러 클래스문이 존재할 수 있는데, 이 여러 클래스문 중 대표클래스(주 클래스)가 무엇인지 명시해놓는 것이 가독성에 도움이 된다,
 그리고 그 대표클래스라는 표식으로 public 을 붙이면 public 이 붙은 클래스명은 해당클래스파일명과 동일해야 하도록 규칙을 정해놓은 것이다.
 */

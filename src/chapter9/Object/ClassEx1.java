package chapter9.Object;
/**
* [ Class객체, ClassLoader, class파일(SomeClass.class), getClass() ]
 * Class객체 : '한클래스'에 대한 모든 정보를 담고 있는 객체, 클래스 당 1개만 존재함 (getClass()메서드를 통해 얻을 수 있음)
 * getClass() : 메서드 자신이 속한 클래스의 'Class객체'를 반환하는 메서드
 * class파일 : '한클래스.java' 파일이 자바컴파일을 거쳐 (binary형태내용의) '한클래스.class' 파일이 된 것
 * ClassLoader : 자바프로그램 실행 시 필요한 클래스를 동적으로 메모리에 로드하는 역할을 하는 것
 *               *실행시*
 *               1. 필요클래스에 대해 기존에 생성된 객체가 메모리상에 존재하는지 확인
 *                1-1. 있으면 -> 객체 참조를 반환(해당객체주소를 알려줌)
 *                1-2. 없으면 -> 2번으로 진행
 *               2. 클래스패스(classpath)에 지정된 경로를 따라서 클래스파일(.class)을 찾는다
 *                2-1. 찾으면 -> 해당 클래스파일을 읽어서 Class객체로 변환
 *                2-2. 못찾으면 -> 'ClassNotFoundException' 을 발생시킴
* */

public class ClassEx1 {
    public static void main(String[] args) throws Exception {

        Card3 c = new Card3("HEART", 3);

        // 방법1 : 내가 만들어본것 => "방법2로 했을때와 동일한 결과가 잘 나옴(정상구동)"
        /*Card3 c2 = null;
        try {
            c2 = Card3.class.newInstance();     // newInstance() 메서드는 'InstantiationException'이란 예외(+ 'InstantiationError' + "IllegalAccessException") 가 발생할 수 있기 때문에 예외처리가 필요
        } catch(InstantiationError | InstantiationException | IllegalAccessException ie) {}*/

        // 방법2: 예제 코드( 메인메서드문에 throws Exception 적어버리기)
        Card3 c2 = Card3.class.newInstance(); // Class객체를 통해서 객체 생성

        Class cObj = c.getClass();

        System.out.println(c);                      // HEART:3
        System.out.println(c2);                     // SPADE:1
        System.out.println(cObj.getName());         // chapter9.Object.Card3                // -> Card3의 Class객체에서 Name을 얻어낸 것
        System.out.println(cObj.toGenericString()); // final class chapter9.Object.Card3    // -> Card3의 Class 객체에 대한 클래스정보 문자열을 출력(modifier와 type parameter까지 포함하는)(Returns a string describing this Class, including information about modifiers and type parameters.)
        System.out.println(cObj.toString());        // class chapter9.Object.Card3          // -> Card3의 Class 객체에 대해 'interface인지 or class 인지 + 클래스명' 정보를 반환한다
    }
}

final class Card3 {
    String kind;
    int num;

    Card3(String kind, int num) {
        this.kind = kind;
        this.num = num;
    }
    Card3() {
        this("SPADE", 1);
    }

    @Override
    public String toString() {
        return kind + ":" + num ;
    }
    
}

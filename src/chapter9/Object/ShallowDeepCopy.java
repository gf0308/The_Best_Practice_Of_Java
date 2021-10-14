package chapter9.Object;

public class ShallowDeepCopy {
    public static void main(String[] args) {
        Circle c1 = new Circle(new Point2(1,1), 2.0);
        Circle c2 = c1.shallowCopy();   // 얕은 복사
        Circle c3 = c1.deepCopy();      // 깊은 복사

        System.out.println("c1="+c1);   // 객체 내부에 toString()을 오버라이딩 해놓았기 때문에 sysout 시 자동으로 toString()으로 출력처리
        System.out.println("c2="+c2);
        System.out.println("c3="+c3);

        // 객체 c2와 c3의 원본인 c1에서 참조타입멤버 p의 내용을 변경한다
        c1.p.x = 9;
        c1.p.y = 9;

        // 원본을 변경해본 후에, 각각 객체들 상태가 어떤지 출력해본다
        System.out.println("= c1의 변경 후");
        System.out.println("c1="+c1);       // c1=[p=(9, 9), r=2.0]
        System.out.println("c2="+c2);       // c2=[p=(9, 9), r=2.0]
        System.out.println("c3="+c3);       // c3=[p=(1, 1), r=2.0]     // -> c3는 깊은복사(deepCopy)로 참조타입멤버객체를 새로 new로 생성해낸것을 초기화해 썼기 때문에, 원본객체 c1의 변경에 영향을 받지 않음

    }

}

class Circle implements Cloneable {
    Point2 p;    // 원점 // (참조타입객체인 멤버변수)
    double r;   // 반지름

    Circle(Point2 p, double r) {
        this.p = p;
        this.r = r;
    }

    // 얕은 복사(shallow copy) 용 메서드 정의
    public Circle shallowCopy() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch(CloneNotSupportedException e) {}

        return (Circle) obj; // 공변반환타입 기능 적용
    }

    // 깊은 복사(deep copy) 용 메서드 정의

    // 방법1(?)(내가만듬)
    /*public Circle deepCopy() {
        Circle c = new Circle(new Point(this.p.x, this.p.y), this.r);
        return c ;
    }*/

    // 방법2 : 예제코드
    public Circle deepCopy() {
        Object obj = null;
        try {   //[Q1] this.clone(); 도 에러는 뜨지 않는데, 왜 super.clone() 으로 클론을 하지? : 즉 왜 조상클래스객체것을 복사해야하는거지?
            obj = super.clone();
        } catch(CloneNotSupportedException e) {}

        Circle c = (Circle) obj;
        c.p = new Point2(this.p.x, this.p.y);    // -> 이렇게 '문제의 그 참조타입멤버변수객체 p를 '새 거'를만든걸로 초기화해줌으로써 -> 깔끔하게 완전복사 조건을 충족하게 되었다

        return c;
    }

    @Override
    public String toString() {
        return "[p=" + p + ", r=" + r + "]";
    }
}

class Point2 {
    int x, y;

    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}


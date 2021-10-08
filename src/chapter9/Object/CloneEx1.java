package chapter9.Object;

public class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(3, 5);
        Point copy = (Point)original.clone();

        // 클래스에 toString()을 별도로 재정의한 내용이 없다면, 인스턴스 출력 시 Object.toString() 대로 '클래스명+@+16진수hashCode' 가 출력되어진다. // ex) Point@1b6d3586
        // 클래스에 toString()이 (멤버변수내용을 출력하도록) 재정의(오버라이딩)되어 있으면, System.out.println(인스턴스) 시 위같은결과가 아닌 (재정의한 toString()대로) 멤버변수값이 출력된다. // ex) x=3, y=5
        System.out.println(original);   // x=3, y=5
        System.out.println(copy);       // x=3, y=5
    }
}

class Point implements Cloneable {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }

    // clone() 재정의 방식2 (B) : 이 방식으로 하면, 현 객체가 clone메서드를 호출하는 시점에 Exception hadnle 처리를 또 해줘야 한다고 뜸.
    /*@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    // clone() 재정의 방식 1 (A) : 이 방식으로 하면, 현 객체가 clone메서드를 호출하는 시점에 Exception hadnle 처리를 또 해줘야 할 일이 없음
    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone(); // 왜 조상클래스의 clone을 호출하고 있음 -> 조상클래스(Object클래스)의 clone을 호출하는 이유 : 당연히 clone 메서드가 조상클래스 Object 에 있으니까.
        } catch(CloneNotSupportedException e) {}
        return obj;
    }


}


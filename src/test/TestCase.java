package test;

public class TestCase {

	public static void main(String[] args) {

		Test myfunc = new Test();
	    myfunc.display(10);
	    myfunc.display(10, 20);
	    myfunc.display(10, 3.14);
	    myfunc.display(10, 'a'); 	// 이 경우에는 두번쨰 파라미터에 'a'가 들어갔는데, 'a'는 int 형으로 parse될수도, double형으로 parse될수도 있음
	    							// -> 두 가지 경우 메서드가 아래 다 존재함 -> '더 작은 범위 형'인 int형 쪽으로 자동으로 간주함 -> (b)가 호출되게 됨

    }

}

class Test {
    void display(int num1) { System.out.println(num1); }						// ..... (a)
    void display(int num1, int num2) { System.out.println(num1 * num2); }		// ..... (b)
    void display(int num1, double num2) { System.out.println(num1 + num2); }	// ..... (c)
}

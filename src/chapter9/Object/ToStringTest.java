package chapter9.Object;

import java.util.Date;

public class ToStringTest {
    public static void main(String[] args) {
        String str = new String("KOREA");
        Date today = new Date();

        // toString() 은 기본디폴트로는 '클래스명@16진수해쉬코드'값을 반환한다(특별한 재정의 없으면)
        // String클래스, Date클래스 같이 몇몇 클래스는 toString()에 대해 '그 안의 내용 멤버변수값을 출력하도록' (내장적으로) 재정의 되어져 있다.
        System.out.println(str);                // KOREA
        System.out.println(str.toString());     // KOREA
        System.out.println(today);              // Sat Oct 09 02:02:53 KST 2021
        System.out.println(today.toString());   // Sat Oct 09 02:02:53 KST 2021
    }

}

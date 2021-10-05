package java_lang_package.Object;

public class HashCodeEx1 {
    public static void main(String[] args) {

        // hashCode 계산 방식이 오리지널방식(메모리주소값을 사용해 반환)의 객체 경우
        EqualsEx1 eq1 = new EqualsEx1();
        EqualsEx1 eq2 = new EqualsEx1();

        System.out.println("==================내가 직접 정의한 클래스(사용자정의클래스)의 두 인스턴스들의 해시코드값 확인====================");

        System.out.println("eq1's hashCode: " + eq1.hashCode());    // 460141958
        System.out.println("eq2's hashCode: " + eq2.hashCode());    // 1163157884

        System.out.println("==================String클래스에 설정되어있는 .hashCode() 메서드로 두 인스턴스의 해시코드값 확인====================");

        // hashCode 계산 도출 방식이 따로 재정의처리 되어있는(메모리주소값사용이아닌) 객체인 경우 (ex: String클래스의 경우 같은문자열값이면 동일한 hashCode를 반환하도록 재정의처리 되어져 있음)
        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println("str1's hashCode: " + str1.hashCode());  // 96354
        System.out.println("str2's hashCode: " + str2.hashCode());  // 96354

        System.out.println("============메모리주소값으로 도출해낸 주소값 기반 해시코드 얻어내기=====================");

        System.out.println("str1's real hashCode: " + System.identityHashCode(str1));  // 1956725890
        System.out.println("str2's real hashCode: " + System.identityHashCode(str2));  // 356573597
    }

}

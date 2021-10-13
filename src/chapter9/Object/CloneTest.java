package chapter9.Object;

public class CloneTest {
   public static void main(String[] args) {
       CloneEx1_2 c1 = new CloneEx1_2(2,3);

       // JDK1.5 이전까지는 '공변반환타입'기능이 지원되지 않았기 때문에 조상의 기능으로부터 오버라이딩(재정의)한 메서드의 타입은 무조건 조상타입(이 경우엔 Object)으로 해주었어야 했었다
       // -> 이로인해 아래처럼 CloneEx1_2 객체를 clone() 해도 바로 CloneEx1_2타입으로 받을 수 있게  CloneEx1_2 타입으로 리턴값이 오는게 아닌, (조상클래스 타입인) Object 타입으로 받아주어야 했었음
       CloneEx1_2 c1_clone = (CloneEx1_2) c1.clone();
       // 혹은
       Object c1_clone_obj = c1.clone();

       // 하지만 공변반환타입(covaraint return type)기능이 지원하기 시작한 이후(JDK1.5) 부턴, 오버라이딩 시 리턴타입을 자손클래스객체타입으로 만들어서 바로 넘겨줄 수 있게 됐다
       CloneEx1_2 c1_clone2 = c1.clone_covariant();
       // -> 형변환(casting)을 또 해주어야 할 필요가 없게 되었음 (편리)
   }
}

package chapter9.Object;

import java.lang.reflect.Array;
import java.util.*;

public class CloneEx2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; // 배열 클래스 역시 Cloneable 인터페이스와 Serializable 인터페이스를 구현하고 있다 -> clone() 호출 가능
        int[] arrClone = arr.clone();
        arrClone[0] = 6;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrClone));



        /********************************************************************************************/

        System.out.println(arr);                     //[I@1b6d3586
        System.out.println(arr.toString());          // [I@1b6d3586
        System.out.println(String.valueOf(arr));    // [I@1b6d3586
        // '객체'를 sysout문으로 바로 출력하면, 해당객체의 '클래스명@객체의16진수HashCode' 가 출력이됨
        // 객체(배열 등)에 toString(), String.valueOf() 를 해봤자 '객체클래스명@해쉬코드'내용에 문자열화 작업만 거는 것에 불과하며, (배열의 경우)배열을 출력할수있는 문자열로 변환하려면 Arrays.toString(배열) 을 사용해야 한다.
        System.out.println(Arrays.toString(arr));   // [1, 2, 3, 4, 5]

        /********************************************************************************************/

        /*배열을 복제하는 방법
        * 1. clone() 이용
        * 2. System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        *
        * */

        // 1 방식
        int[] arrClone1 = arr.clone();  // 배열클래스는 clone() 에 대해 자기자신 객체타입을 리턴하도록('공변 반환타입') 오버라이딩 되어 있음
        System.out.println("arrClone1: " + Arrays.toString(arrClone1));


        // 2 방식
        int[] arrClone2 = new int[arr.length];
        System.arraycopy(arr, 0, arrClone2, 0, arr.length);

        System.out.println( "arrClone2: " + Arrays.toString(arrClone2) );



        /******************************************************************/

        // 그 밖에 .clone() 호출이 가능한 java.util 패키지의 클래스들
        // : Vector, ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap, Calendar, Date
        // ==> 위 클래스들 모두 clone() 에 대해 공변반환타입 식 오버라이딩은 되어 있지 않음(조상클래스 타입으로 리턴함)

        Vector<String> v1 = new Vector<>();
        Vector<String> v1Clone = (Vector) v1.clone(); // Vector 클래스에선 clone()에 공변반환타입 식 오버라이딩이 되어있지 않음

        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a1Clone = (ArrayList) a1.clone(); // ArrayList 클래스에선 clone()에 공변반환타입 식 오버라이딩이 되어있지 않음

        HashSet<String> h1 = new HashSet<>();
        HashSet<String> h1Clone = (HashSet<String>) h1.clone();

        TreeSet<String> t1 = new TreeSet<>();
        TreeSet<String> t1Clone = (TreeSet<String>) t1.clone();

        TreeMap<String,String> tm1 = new TreeMap<>();
        TreeMap<String,String> tm1Clone = (TreeMap<String,String>) tm1.clone();

        Calendar cal = Calendar.getInstance();
        Calendar calClone = (Calendar) cal.clone();

        Date d1 = new Date();
        Date d1Clone = (Date) d1.clone();
    }
}

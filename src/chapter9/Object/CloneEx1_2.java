package chapter9.Object;

public class CloneEx1_2 {
    int x, y;

    CloneEx1_2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    CloneEx1_2() {
        this(1,1);
    }

    @Override
    public Object clone()  {
        Object obj = null;
        try {
            obj = super.clone(); // 조상객체를 복제해서 리턴
        } catch(CloneNotSupportedException e) {}

        return obj;
    }

    public CloneEx1_2 clone_covariant() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch(CloneNotSupportedException e) {}

        return (CloneEx1_2) obj;
    }
}

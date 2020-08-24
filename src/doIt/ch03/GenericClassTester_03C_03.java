package doIt.ch03;

/**
 * 제네릭 클래스의 예
 */
public class GenericClassTester_03C_03 {

    //제네릭 클래스의
    static class GenericClass<T> {
        private T xyz;

        public GenericClass(T xyz) {
            this.xyz = xyz;
        }

        public T getXyz() {
            return xyz;
        }
    }

    public static void main(String[] args) {
        //다음과 같이 파라미터에 String를 넘길 수도 있고 Integer를 넘길 수도 있다.
        GenericClass<String> s = new GenericClass<>("ABC");
        GenericClass<Integer> n = new GenericClass<>(15);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }

}

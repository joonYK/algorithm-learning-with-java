package doIt.ch03;

/**
 * 클래스 메서드와 인스턴스 메서드
 */

class Id {
    private static int counter = 0; //아이디를 몇 개 부여했는지 저장
    private int id; //아이디

    public Id() {
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }
}

public class IdTester_03C_01 {
    public static void main(String[] args) {
        Id a = new Id();
        Id b = new Id();

        System.out.println("a의 아이디 : " + a.getId());
        System.out.println("b의 아이디 : " + b.getId());

        System.out.println("부여한 아이디의 개수 : " + Id.getCounter());
    }
}

package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); // static 영역에 객체를 1개만 생성

    public static SingletonService getInstance() { // 객체 인스턴스가 필요하면 getInstance를 통해 조회한다.
        return instance;
    }

    // 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

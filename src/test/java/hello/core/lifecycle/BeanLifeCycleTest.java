package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        // ConfigurableApplicationContext 사용 이유
        // ApplicationContext 인터페이스에 없는 몇 가지 추가 기능을 제공
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();

    }

    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            // 스프링 빈은 객체를 생성하고 의존관계 주입이 다 끝난 후 필요한 데이터를 사용할 준비가 완료된다.
            // 초기화 작업은 의존관계 주입이 모두 완료되고 난 다음 호출해야한다. 개발자가 의존관계 완료가 된 시점을 어떻게 알지?
            // 스프링은 의존관계 주입이 완료되면 스프링 빈에세 콜백 메서드를 통해 알려준다. 스프링 컨테이너가 종료디기 직전에 소멸 콜백을 준다.
            // 스프링 빈의 이벤트 라이프 사이클
            // 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
            return networkClient;
        }
    }
}

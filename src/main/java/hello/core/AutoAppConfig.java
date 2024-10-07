package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class))
public class AutoAppConfig {

    // 테스트 오류 : 컴포넌트 스캔으로 스프링 빈에 등록되어있는데 재등록시 충돌오류가 난다.
//    @Bean(name = "memoryMemberRepository")
//    MemoryMemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
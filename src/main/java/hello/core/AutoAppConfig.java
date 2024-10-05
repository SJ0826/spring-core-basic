package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // 모든 패키지를 검색하면 오래걸린다. 필요한 패키지만 검색한다.
        basePackageClasses = AutoAppConfig.class, // AutoAppConfig 자체를 BasePackage로 등록
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class))
public class AutoAppConfig {
}
package study.springcoreprinciple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import study.springcoreprinciple.member.MemberRepository;
import study.springcoreprinciple.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
//        basePackages = "study.springcoreprinciple.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    // 수동등록빈이 자동빈을 Overriding 함. But SpringBootApplication으로 실행하면 오류가남 -> 스프링에서 사용하지못하도록 했기때문
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}

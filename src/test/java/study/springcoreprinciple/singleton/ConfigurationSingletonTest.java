package study.springcoreprinciple.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springcoreprinciple.AppConfig;
import study.springcoreprinciple.member.MemberRepository;
import study.springcoreprinciple.member.MemberServiceImpl;
import study.springcoreprinciple.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        var memberService = ac.getBean("memberService", MemberServiceImpl.class);
        var orderService = ac.getBean("orderService", OrderServiceImpl.class);
        var memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        var memberRepository1 = memberService.getMemberRepository();
        var memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberRepository1).isSameAs(memberRepository2).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        var bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}

package study.springcoreprinciple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springcoreprinciple.discount.DiscountPolicy;
import study.springcoreprinciple.discount.FixDiscountPolicy;
import study.springcoreprinciple.discount.RateDiscountPolicy;
import study.springcoreprinciple.member.MemberRepository;
import study.springcoreprinciple.member.MemberService;
import study.springcoreprinciple.member.MemberServiceImpl;
import study.springcoreprinciple.member.MemoryMemberRepository;
import study.springcoreprinciple.order.OrderService;
import study.springcoreprinciple.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean // Spring Container로 등록
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}

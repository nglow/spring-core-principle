package study.springcoreprinciple.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.springcoreprinciple.AppConfig;
import study.springcoreprinciple.member.Grade;
import study.springcoreprinciple.member.Member;
import study.springcoreprinciple.member.MemberService;
import study.springcoreprinciple.member.MemberServiceImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        var appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        var member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}

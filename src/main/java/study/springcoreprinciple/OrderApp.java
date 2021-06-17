package study.springcoreprinciple;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springcoreprinciple.member.Grade;
import study.springcoreprinciple.member.Member;
import study.springcoreprinciple.member.MemberService;
import study.springcoreprinciple.order.Order;
import study.springcoreprinciple.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
//        var appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        var applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        var memberService = applicationContext.getBean("memberService", MemberService.class);
        var orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        var member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}

package study.springcoreprinciple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springcoreprinciple.member.Grade;
import study.springcoreprinciple.member.Member;
import study.springcoreprinciple.member.MemberService;
import study.springcoreprinciple.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
//        var appConfig = new AppConfig();
//        var memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        var memberService = applicationContext.getBean("memberService", MemberService.class);

        var member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        var memberRetrieved = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("memberRetrieved = " + memberRetrieved.getName());
    }
}
